package cn.generated;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import  java.sql.*;
import java.util.Properties;
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

        String driver =null;
        String url=null;
        String userName=null;
        String password=null;
        try {
            //构造输入流,读入参数文件的内容
            File file = new File("conf/local.properties");
            InputStream is = new FileInputStream(file);
            //将参数文件的内容装载到Map对象props中
            Properties props = new Properties();
            props.load(is);
            driver = props.getProperty("db.driver");
            url = props.getProperty("db.url");
            userName = props.getProperty("db.username");
            password = props.getProperty("db.password");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Connection conn = null;
        try {
            System.out.print("1");
            Class.forName(driver).newInstance();
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
