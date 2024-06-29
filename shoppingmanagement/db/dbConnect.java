package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Statement;

public final class dbConnect {

    public static Connection getconn() {
        Connection conn = null;

        String url = "jdbc:mysql://127.0.0.1/cainiaoshopping"; // 本地learn_sql数据库地址
        String username = "root";// MySQL数据库登录用户名
        String password = "123456";// MySQL数据库登录密码

        // 已加载完驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");// 加载MySQL数据库驱动
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }

}
