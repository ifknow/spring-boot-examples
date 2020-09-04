package com.ifknow.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ifknow
 * @since 2020-09-04
 */
@Data
public class Permission implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Integer id;

    /**
     * 权限名
     */
    private String permissionName;

    /**
     * 说明
     */
    private String remarks;
}
