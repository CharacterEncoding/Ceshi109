package com.he.ceshi109.service;

//import com.he.ceshi109.dao.UserDao;
import com.he.ceshi109.entity.User;
import com.he.ceshi109.impdao.UserDao;
import com.he.ceshi109.utils.MyBatisUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {
    @Resource
    private UserDao userDao;

//    private UserDao userDao = MyBatisUtil.getSession().getMapper(UserDao.class);

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true, isolation = Isolation.READ_COMMITTED )
    public User selectByName(String name) {
        User user = userDao.selectByName(name);
        return user;
    }

//    @Transactional(propagation = Propagation.REQUIRED,readOnly = false,isolation = Isolation.READ_COMMITTED)
    public void reg(User user){
        userDao.reg(user);
    }
}
