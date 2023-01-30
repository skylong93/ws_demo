package com.king.ws.script;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.*;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

/**
 * @Author wangyonglong
 * @Date 2023/1/4 10:51 上午
 * @Desc
 **/
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
@ComponentScan(basePackages = "com.king.ws")
public class PipelineOrderScript {

    @Test
    public void pipelineOrderData() throws Exception {
        JSch jsch = new JSch();
        Session session = jsch.getSession("work", "47.95.196.72", 22);
        session.setPassword("!zhangyu919^");
        session.setConfig("StrictHostKeyChecking", "no");
        session.connect();
        session.setPortForwardingL("localhost", 5656, "47.95.196.72", 3306);
        session.setPortForwardingL("47.95.196.72", 3306, "127.0.0.1", 3306);
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        String url = "jdbc:mysql://localhost:5656/target_force";
        Connection conn = DriverManager.getConnection(url, "work", "Work_2022^");
        System.out.println("连接成功");
    }

    @Test
    public void pipelineOrderData2() throws Exception {
        JSch jsch = new JSch();
        Session session = jsch.getSession("wangyonglong", "180.76.179.64", 22);
        session.setPassword("@123king");
        session.setConfig("StrictHostKeyChecking", "no");
        session.connect();
        session.setPortForwardingL("localhost", 5656, "180.76.179.64", 3306);
//        session.setPortForwardingL("180.76.179.64", 5656, "180.76.179.64", 3306);
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        String url = "jdbc:mysql://localhost:5656/dev01_target_force?useSSL=false&useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true&serverTimezone=Hongkong";
        Connection conn = DriverManager.getConnection(url, "dev_work", "dev_work2022");
        System.out.println("连接成功");

        String sql = "select * from attribute limit 10";
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();

        List<Map> list = new ArrayList<>();
        ResultSetMetaData md = rs.getMetaData();//获取键名
        int columnCount = md.getColumnCount();//获取列的数量
        while (rs.next()) {
            Map<String,Object> rowData = new HashMap<>();//声明Map
            for (int i = 1; i <= columnCount; i++) {
                rowData.put(md.getColumnName(i), rs.getObject(i));//获取键名及值
            }
            list.add(rowData);
        }
        System.out.println(JSON.toJSONString(list));
    }
}
