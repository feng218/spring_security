package com.yufeng.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by Administrator on 2019/10/13.
 */
@RunWith(SpringRunner.class)   //使用什么方式运行
@SpringBootTest
public class UserControllerTest
{
    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    //在每次测试用例之前执行
    @Before
    public void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void whenQuerySuccess() throws Exception
    {
        mockMvc.perform(MockMvcRequestBuilders.get("/user")
                .param("username", "jojo")
                .contentType(MediaType.APPLICATION_JSON_UTF8))

                //响应码判断为200
                .andExpect(MockMvcResultMatchers.status().isOk())

                //返回集合的长度为3
                //$: 响应参数的根元素
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3));
    }
}
