package com.he.ceshi109.utils;

import com.he.ceshi109.test.TestBatis;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class MyBatisUtil {
    public static SqlSession getSession(){
        InputStream in = MyBatisUtil.class.getResourceAsStream("/mybatis-config.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sessionFactory = builder.build(in);
        return  sessionFactory.openSession(true);
    }
}
