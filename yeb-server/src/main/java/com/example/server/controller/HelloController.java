package com.example.server.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试
 * 无参用getmapping
 * 有参用postmapping
 */
@RestController
public class HelloController {
    @GetMapping(value = "/user")
    public boolean getUser(){
        return true;
    }
    @ApiOperation("可以指定参数的API")
    @PostMapping("/param")
    public String hello2(@ApiParam("用户名") @RequestParam String name, @ApiParam("成绩") @RequestParam int num){
        System.out.println(name);
        return "hello" + name + num;
    }
}