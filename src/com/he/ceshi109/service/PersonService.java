package com.he.ceshi109.service;


import com.he.ceshi109.entity.Person;
import com.he.ceshi109.impdao.PersonDao;
import com.he.ceshi109.utils.MyBatisUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PersonService {
    @Resource
    private PersonDao personDao;

//    private PersonDao personDao = MyBatisUtil.getSession().getMapper(PersonDao.class);

    public Person selectById(int id) {
        Person p = personDao.selectById(id);
        return p;
    }

    public List<Person> selectAll() {
        List<Person> list = personDao.selectAll();
        return list;
    }

    public List<Person> selectByPage(int numpage, int size) {
        List<Person> list = personDao.selectByPage((numpage - 1) * size, size);
        return list;
    }

    public int selectCount() {
        int i = personDao.selectCount();
        return i;
    }

    public void insert(Person p) {
        personDao.insert(p);
    }

    public void update(Person p) {
        personDao.update(p);
    }

    public void delete(int id) {
        personDao.delete(id);
    }

    public List<Person> selectByName(String name) {
        List<Person> list = personDao.selectByName(name);
        return list;
    }
}
