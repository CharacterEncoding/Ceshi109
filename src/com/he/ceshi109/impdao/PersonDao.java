package com.he.ceshi109.impdao;

import com.he.ceshi109.entity.Person;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface PersonDao {

    @Select("select * from per3 where id = #{id}")
    Person selectById(int id);

    @Select("select * from per3")
    List<Person> selectAll();

//    List selectByPage(Map map);
    @Select("select * from per3 where state = 0 limit #{offset},#{size}")
    List<Person> selectByPage(@Param("offset") int offset, @Param("size") int size );

    @Select("select count(id) from per3")
    int selectCount();

    @Insert("insert into per3 (name,sex,age) values (#{name},#{sex},#{age})")
    void insert(Person person);

    @Update("update per3 set name=#{name},sex=#{sex},age=#{age} where id = #{id}")
    void update(Person person);

    @Delete("update per3 set state = 1 where id = #{id}")
    void delete(int id);

    @Select("select * from per3 where name like \"%\"#{name}\"%\"")
    List<Person> selectByName(String name);
}
