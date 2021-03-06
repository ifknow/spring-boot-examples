package com.ifknow.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ifknow
 * @since 2020-09-04
 */
@Data
public class UserRole implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer userId;

    private Integer roleId;
}
