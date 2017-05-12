package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 连接数据库以及关闭数据库
 * 两个都为静态方法，可以直接调用
 * Created by pc on 17-5-11.
 */
public class DataBaseUtil {

    //连接数据库
    public static Connection getConn() {
        Connection conn = null;
        try {
            //加载数据库驱动
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:mysql://localhost:3306/jdbcdemo?useUnicode=true&characterEncoding=UTF-8";
        try {
            conn = DriverManager.getConnection(url, "root", "root");
            if (conn != null) {
                System.out.println(1123);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    //关闭数据库
    public static void closeConn(Connection conn){
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
