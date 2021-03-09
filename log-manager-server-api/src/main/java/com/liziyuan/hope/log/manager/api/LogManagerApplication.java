package com.liziyuan.hope.log.manager.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(value = {"com.liziyuan.hope.log.manager.das"})
@EnableAsync
@EnableCaching
@ComponentScan(basePackages = {"com.liziyuan.hope.log.manager"})
public class LogManagerApplication {
    public static void main(String[] args) {
        SpringApplication.run(LogManagerApplication.class, args);
        System.out.println(">>>>>>>>>>>>>启动成功>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }
}
