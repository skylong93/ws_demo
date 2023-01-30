package com.king.ws.service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author wangyonglong
 * @Date 2023/1/9 10:55 上午
 * @Desc
 **/
@RestController
@RequestMapping("/api/user")
public class UserController {

    @GetMapping("/getList")
    public String getContact(String query) {
        return "返回query:" + query;
    }
}
