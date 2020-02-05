package com.chenzj36.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Author Danny Lyons
 * @Email chenzj36@live.cn
 * @Time 2020/2/3 17:33
 * @Description
 */
@RestController
public class JDBCController {
    //JdbcTemplate是core包的核心类
    //简化JDBC操作，SpringBoot为其提供了数据源
    @Autowired
    JdbcTemplate jdbcTemplate;

   //查询user表中的所有数据，没有实体类对应的情况下，使用
   //List<Map<String,Object>>接收，每一行为一个Map.
    @GetMapping("/userList")
    public List<Map<String,Object>> userList(){
        String sql = "select * from user";//查询语句
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        return list;
    }

    //增加
    @GetMapping("/addUser")
    public String addUser(){
        String sql = "insert into mybatis.user(id,username,password) " +
                "values('10','ddd','10') ";
        //执行增、删和改都用update
        jdbcTemplate.update(sql);
        return "addUser ok";
    }


    //修改
    @GetMapping("/updateUser/{id}")
    public String updateUser(@PathVariable("id") int id){
        String sql = "update mybatis.user set username=?," +
                "password=? where id="+id;
        Object[] objects = new Object[2];
        objects[0] = "name";
        objects[1] = "passwd";
        jdbcTemplate.update(sql,objects);
        return "updateUser ok";
    }

    //删除
    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") int id){
        String sql = "delete from mybatis.user where id="+id;
        jdbcTemplate.update(sql);
        return "deleteUser ok";
    }

}
