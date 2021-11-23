package com.he.ceshi109.test;

import com.he.ceshi109.entity.Person;
import com.he.ceshi109.impdao.PersonDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class TestPersonDao {

    @Resource
    private PersonDao personDao;

    @Test
    public void test1(){
        System.out.println(personDao.selectById(8));
    }

    @Test
    public void test2(){
        System.out.println(personDao.selectAll());
    }

    @Test
    public void test3(){
        System.out.println(personDao.selectByPage(0, 1));
    }

    @Test
    public void test4(){
        System.out.println(personDao.selectCount());
    }

    @Test
    public void test5(){
        personDao.insert(new Person("lyj","nb",12));
    }
}
