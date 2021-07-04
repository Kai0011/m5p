package com.data.m5p;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import tk.mybatis.spring.annotation.MapperScan;
import xyz.erupt.core.annotation.EruptScan;


@MapperScan(basePackages = "com.data.m5p.mapper")
@SpringBootApplication
@EntityScan
@EruptScan
public class M5pApplication {

    public static void main(String[] args) { SpringApplication.run(M5pApplication.class, args); }

}
