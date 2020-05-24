package com.wechat.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author xhua
 * @Date 2020/5/8 11:49
 **/
@RestController
@RequestMapping("test")
public class TestController {

    @GetMapping("hello")
    public String test(){
        return "index";
    }

}
