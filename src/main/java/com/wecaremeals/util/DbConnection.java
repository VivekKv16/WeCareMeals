package com.wecaremeals.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    static Connection con=null;
    public static Connection getConnection() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        con =DriverManager.getConnection("jdbc:mysql://localhost:3306/wecaremeals", "root", "vivek");
        System.out.println("succefully Connected");
        return con;
    }
}
