package com.chenzj36;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class Data3ApplicationTests {
    //自动注入数据源
    @Autowired
    DataSource dataSource;
    @Test
    void contextLoads() throws SQLException {
        //输出默认数据源的信息
        System.out.println(dataSource.getClass());
        //获得连接
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        //关闭连接
        connection.close();
    }
}
