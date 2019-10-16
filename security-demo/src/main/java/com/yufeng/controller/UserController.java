package com.yufeng.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.yufeng.entities.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/10/13.
 */
@RestController
@RequestMapping("/user")
public class UserController
{
    @GetMapping("hello")
    public String hello()
    {
        return "hello";
    }

    @GetMapping
    @JsonView(User.SimpleView.class)
    public List<User> queryList(User user,
                //给分页对象设置默认值
                @PageableDefault(page = 2, size = 2, sort = "username,asc")  Pageable pageable)
    {
        System.out.println(user);
        List<User> list = new ArrayList<>();
        list.add(user);
        return list;
    }

    //@GetMapping("/{id}")
    @GetMapping("/{id:\\d+}")  //正则表达式, 参数必须是全数字
    @JsonView(User.DetailView.class)
    //public User getInfo(@PathVariable Integer id){
    public User getInfo(@PathVariable(name = "id") Integer userId){
        User user = new User();
        user.setId(userId);
        user.setUsername("Tom");
        return user;
    }

    @PostMapping
    public User create(@RequestBody @Valid User user, BindingResult bindingResult){
        if(bindingResult.hasErrors())   //校验是否有错
        {
            bindingResult.getAllErrors()
                    .stream().forEach(error -> System.out.println(error.getDefaultMessage()));
            return new User();
        }
        System.out.println(user);
        user.setId(1);
        return user;
    }
}
