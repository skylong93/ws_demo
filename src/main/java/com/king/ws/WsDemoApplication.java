package com.king.ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author wangyonglong
 * @Date 2023/1/3 3:40 下午
 * @Desc
 **/

@SpringBootApplication
//@ComponentScan(basePackages = {"com.king.ws"})
public class WsDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(WsDemoApplication.class, args);
    }
}

