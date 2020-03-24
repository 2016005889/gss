package com.tyut.apps.gss;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.tyut.apps.gss.mapper")
public class GssApplication {

    public static void main(String[] args) {
        SpringApplication.run(GssApplication.class, args);
    }

}
