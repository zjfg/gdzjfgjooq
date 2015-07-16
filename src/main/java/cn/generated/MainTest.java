package cn.generated;
import  java.sql.*;
import  javax.xml.transform.*;

import cn.generated.tables.Vb;
import  org.jooq.*;
import  org.jooq.Result;
import  org.jooq.impl.*;
import static cn.generated.Tables.*;

/**
 * Created by zhujie on 15/7/16.
 */
public class MainTest {


    public static void main(String[] args) {
        Connection conn = null;
        String userName = "root";
        String password = "123456";
        String url = "jdbc:mysql://localhost:3306/mnf";
        try {
            System.out.print("1");
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(url, userName, password);
            DSLContext create = DSL.using(conn, SQLDialect.MYSQL);
            Result<Record> result = create.select().from(VB).fetch();
            System.out.println("result==="+result);
            conn.close();
        } catch (Exception e) {
            // You'll probably want to handle the exceptions in a real app
            // Don't ever do this silence catch(Exception e) thing. I've seen this in
            // live code and it is horrendous.
            e.printStackTrace();
        }

    }
}
