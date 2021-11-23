package com.he.ceshi109.test;

import com.he.ceshi109.entity.Person;
import com.he.ceshi109.entity.User;
import com.he.ceshi109.impdao.PersonDao;
import com.he.ceshi109.impdao.UserDao;
import com.he.ceshi109.service.PersonService;
import com.he.ceshi109.service.UserService;
import com.he.ceshi109.utils.MyBatisUtil;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

public class TestBatis {

 private UserDao userDao = MyBatisUtil.getSession().getMapper(UserDao.class);
   private PersonDao personDao = MyBatisUtil.getSession().getMapper(PersonDao.class);

    @Test
    public void test11() {
        System.out.println(userDao.selectByName("cjt"));
    }

    @Test
    public void test21(){
        System.out.println(userDao.selectAll());
    }

    @Test
    public void test3(){
        userDao.reg(new User("aaa","123"));
    }

    @Test
    public void test44(){
        UserService us = new UserService();
        System.out.println(us.selectByName("cjt"));
    }

    @Test
    public void test1() {
        System.out.println(personDao.selectById(8));
    }

    @Test
    public void test2() {
        System.out.println(personDao.selectAll());
    }

    /*@Test
    public void test3(){
        Map map = new HashMap();
        map.put("page", 0);
        map.put("rows", 2);
        System.out.println(personDao.selectByPage(map));
    }*/

    @Test
    public void test4() {
        System.out.println(personDao.selectByPage(1, 2));
    }

    @Test
    public void test5() {
        System.out.println(personDao.selectCount());
    }

    @Test
    public void test6() {
        personDao.insert(new Person("李豪", "男", 20));
    }

    @Test
    public void test7() {
        personDao.update(new Person(51, "张小鑫", "女", 11));
    }

    @Test
    public void test8() {
        personDao.delete(51);
    }

    @Test
    public void test9() {
        System.out.println(personDao.selectByName("张"));
    }

    @Test
    public void test10() {
        PersonService personService = new PersonService();
//        System.out.println(personService.selectAll());
        System.out.println(personService.selectByPage(2, 2));
    }
}
