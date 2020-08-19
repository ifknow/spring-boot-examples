package com.ifknow.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author: ifknow <br>
 * @Date: 2020/8/19  11:01 <br>
 * @Description: 定时任务
 */
@Component
public class SchedulerOutPutTask {
    @Scheduled(cron = "*/5 * * * * ?")
    public void schedulerOutPutTask() {
        System.out.println(new Date());
    }
}
