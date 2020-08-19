package com.ifknow.poio;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author: GongShiYong <br>
 * @Date: 2020/8/19  10:04 <br>
 * @Description: NO Description
 */
@Data
@AllArgsConstructor
public class User {
    private String id;
    private String name;
    private Integer age;
}
