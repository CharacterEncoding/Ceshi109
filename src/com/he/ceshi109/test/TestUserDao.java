package com.he.ceshi109.test;

import com.he.ceshi109.entity.User;
import com.he.ceshi109.impdao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class TestUserDao {

    @Resource
    private UserDao userDao;

    @Test
    public void test1(){
        System.out.println(userDao.selectAll());
    }

    @Test
    public void test2(){
        System.out.println(userDao.selectByName("hjm"));
    }

    @Test
    public void test3(){
        System.out.println(userDao.selectByName("hjm"));
    }

    @Test
    public void test4(){
        userDao.reg(new User("zsg","111"));
    }
}
