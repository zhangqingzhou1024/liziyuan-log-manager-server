package com.liziyuan.hope.log.manager.elastic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

/**
 * @autor zhangqingzhou
 * @description
 * @date 2021/5/28
 **/
@SpringBootApplication
public class MainApplication {
    @PostConstruct
    public void init() {
        // 解决netty启动冲突问题
        // see Netty4Utils.setAvailableProcessors()
        System.setProperty("es.set.netty.runtime.available.processors", "false");
    }

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }
}
