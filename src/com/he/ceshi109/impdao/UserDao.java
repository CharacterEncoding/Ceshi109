package com.he.ceshi109.impdao;

import com.he.ceshi109.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDao {
    @Select("select * from user")
    List<User> selectAll();

    @Select("select * from user where name = #{name}")
    User selectByName(String name);

    @Insert("insert into user (name,password) values (#{name},#{password})")
    void reg(User user);

}
