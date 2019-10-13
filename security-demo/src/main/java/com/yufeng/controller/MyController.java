package com.yufeng.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2019/10/13.
 */
@RestController
public class MyController
{
    @GetMapping("hello")
    public String hello()
    {
        return "hello";
    }
}
