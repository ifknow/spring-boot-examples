package com.ifknow.pojo.bo;

import lombok.Data;

/**
 * @Author: GongShiYong <br>
 * @Date: 2020/8/19  16:23 <br>
 * @Description: NO Description
 */
@Data
public class UserUpdateBO {
    private String id;
    private String name;
    private Integer age;
    private Byte gender;
}
