package com.jdragon.springbootNative.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: 王富贵
 * @description:
 * @createTime: 2022/11/26 21:11
 */
@RestController
public class TestController {
    @GetMapping("/")
    public String tt(){
        return "Hello spring native";
    }
}
