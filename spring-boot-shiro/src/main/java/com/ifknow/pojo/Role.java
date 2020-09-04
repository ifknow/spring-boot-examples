package com.ifknow.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ifknow
 * @since 2020-09-04
 */
@Data
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Integer id;

    /**
     * 角色名
     */
    private String roleName;

    /**
     * 说明
     */
    private String remarks;
}
