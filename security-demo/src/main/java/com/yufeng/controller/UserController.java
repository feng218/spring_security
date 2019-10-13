package com.yufeng.controller;

import com.yufeng.entities.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/10/13.
 */
@RestController
public class UserController
{
    @GetMapping("hello")
    public String hello()
    {
        return "hello";
    }

    @GetMapping("/user")
    public List<User> queryList(@RequestParam String username,

                //给分页对象设置默认值
                @PageableDefault(page = 2, size = 2, sort = "username,asc")  Pageable pageable)
    {
        System.out.println(username);
        List<User> list = new ArrayList<>();
        list.add(new User());
        list.add(new User());
        list.add(new User());
        return list;
    }
}
