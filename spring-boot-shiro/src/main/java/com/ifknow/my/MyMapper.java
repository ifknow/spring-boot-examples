package com.ifknow.my;

/**
 * @author: ifknow <br>
 * @date: 2020/9/4  9:42 <br>
 * @description: NO Description
 */

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 继承自己的MyMapper
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
