package com.he.ceshi109.test;

import com.he.ceshi109.entity.User;
import com.he.ceshi109.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class TestUserService {

    @Resource
    private UserService userService;

    @Test
    public void test1(){
        System.out.println(userService.selectByName("hjm"));
    }

    @Test
    public void test2(){
        userService.reg(new User("def","123"));
    }
}
