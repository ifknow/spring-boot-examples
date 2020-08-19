package com.ifknow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringBootShedulerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootShedulerApplication.class, args);
    }

}
