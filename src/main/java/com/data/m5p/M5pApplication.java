package com.data.m5p;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;


@MapperScan(basePackages = "com.data.m5p.mapper")
@SpringBootApplication
public class M5pApplication {

    public static void main(String[] args) { SpringApplication.run(M5pApplication.class, args); }

}
