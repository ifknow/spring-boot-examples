package com.ifknow.aop.aspect;

import com.alibaba.fastjson.JSON;
import com.ifknow.aop.annotation.MyLog;
import com.ifknow.mapper.BaseLogMapper;
import com.ifknow.pojo.model.BaseLog;
import com.ifknow.utils.HttpContextUtils;
import com.ifknow.utils.IPUtils;
import com.ifknow.utils.TypeHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.UUID;

/**
 * @author: GongShiYong <br>
 * @date: 2020/11/9  14:47 <br>
 * @description: 系统日志切面
 */
@Aspect
@Component
@Slf4j
public class SysLogAspect {
    @Autowired
    private BaseLogMapper logMapper;

    /**
     * 配置织入点(以@MyLog注解为标志)
     * 只要出现 @MyLog注解都会进入
     */
    @Pointcut("@annotation(com.ifknow.aop.annotation.MyLog)")
    public void logPointCut() {

    }

    /**
     * 环绕增强
     *
     * @param point
     * @return
     * @throws Throwable
     */
    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        Throwable ex = null;
        Object result = null;

        long beginTime = System.currentTimeMillis();
        //执行方法
        try {
            result = point.proceed();
        } catch (Throwable e) {
            ex = e;
        }
        //执行时长(毫秒)
        long time = System.currentTimeMillis() - beginTime;

        //保存日志
        try {
            saveSysLog(point, time, ex);
        } catch (Exception e) {
            log.error("e={}", e);
        }
        if (ex != null) {
            throw ex;
        }
        return result;
    }

    /**
     * 把日志保存
     *
     * @param joinPoint
     * @throws
     */
    private void saveSysLog(ProceedingJoinPoint joinPoint, long time, Throwable ex) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        BaseLog baseLog = new BaseLog();
        MyLog myLog = method.getAnnotation(MyLog.class);
        if (myLog != null) {
            //注解上的描述
            baseLog.setOperation(myLog.title() + "-" + myLog.action());
        }

        //请求的方法名
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        baseLog.setMethod(className + "." + methodName + "()");
        //打印该方法耗时时间
        log.info("请求{}.{}耗时{}毫秒", className, methodName, time);
        try {
            //请求的参数
            Object[] args = joinPoint.getArgs();
            String params = null;
            if (args.length != 0) {
                params = JSON.toJSONString(args);
            }

            baseLog.setParams(params);
        } catch (Exception e) {

        }
        if (ex != null) {
            baseLog.setResult("error");
            if (StringUtils.isNotEmpty(ex.getMessage())) {
                int messageLength = Math.min(ex.getMessage().length(), 1000);
                String errorMessage = StringUtils.isEmpty(ex.getMessage()) ? null : ex.getMessage().substring(0,
                        messageLength);
                baseLog.setErrorMsg(errorMessage);
            }

            String stackTraceFullMessage = TypeHelper.getExcetionStackTrace(ex);
            if (!StringUtils.isEmpty(stackTraceFullMessage)) {
                int stackTraceLength = Math.min(stackTraceFullMessage.length(), 4000);
                String stackTrace = org.springframework.util.StringUtils.isEmpty(stackTraceFullMessage) ? null :
                        stackTraceFullMessage.substring(0, stackTraceLength);
                baseLog.setErrorStackTrace(stackTrace);
            }
        } else {
            baseLog.setResult("success");
        }

        //获取request
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        //设置IP地址
        baseLog.setIp(IPUtils.getIpAddr(request));
        log.info("Ip{}，接口地址{}，请求方式{}，入参：{}", baseLog.getIp(), request.getRequestURL(), request.getMethod(),
                baseLog.getParams());
        baseLog.setId(UUID.randomUUID().toString().replace("-", ""));
        baseLog.setTime((int) time);
        baseLog.setGmtCreatedTime(new Date());
        log.info(baseLog.toString());
        logMapper.insertSelective(baseLog);
    }
}
