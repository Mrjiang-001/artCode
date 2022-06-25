package com.artcode.controller;

import com.artcode.util.ApiResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 测试类
 * @author: mhqf
 * @Date: 2022-06-25 18:48
 **/
@RestController
@RequestMapping(value = "/test")
public class TestController {

    @RequestMapping(value = "/test")
    public ApiResponse test() {
        return ApiResponse.successOfMessage("github有个大bug");
    }
}
