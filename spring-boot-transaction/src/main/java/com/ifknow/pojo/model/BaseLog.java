package com.ifknow.pojo.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author: GongShiYong <br>
 * @date: 2020/11/9  14:50 <br>
 * @description: 系统日志
 */
@Data
@Table(name = "base_log")
public class BaseLog {

    @Id
    private String id;
    private String operation;
    private Integer time;
    private String method;
    private String params;
    private String ip;

    private String result;

    @Column(name = "error_msg")
    private String errorMsg;

    @Column(name = "error_stack_trace")
    private String errorStackTrace;

    @Column(name = "gmt_created_time")
    private Date gmtCreatedTime;
}
