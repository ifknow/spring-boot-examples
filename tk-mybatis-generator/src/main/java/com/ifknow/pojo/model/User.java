package com.ifknow.pojo.model;

import javax.persistence.*;

public class User {
    /**
     * 主键
     */
    @Id
    private String id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别（0-女 1-男）
     */
    private Byte gender;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public String getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取姓名
     *
     * @return name - 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置姓名
     *
     * @param name 姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取年龄
     *
     * @return age - 年龄
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 设置年龄
     *
     * @param age 年龄
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 获取性别（0-女 1-男）
     *
     * @return gender - 性别（0-女 1-男）
     */
    public Byte getGender() {
        return gender;
    }

    /**
     * 设置性别（0-女 1-男）
     *
     * @param gender 性别（0-女 1-男）
     */
    public void setGender(Byte gender) {
        this.gender = gender;
    }
}