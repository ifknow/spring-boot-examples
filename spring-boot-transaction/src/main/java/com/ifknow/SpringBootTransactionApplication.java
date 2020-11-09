package com.ifknow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.ifknow.mapper")
@EnableTransactionManagement
public class SpringBootTransactionApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootTransactionApplication.class, args);
    }

}
