package com.ifknow.pojo;
import lombok.Data;

import java.io.Serializable;

/**
 * @author ifknow
 * @since 2020-09-04
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;
}
