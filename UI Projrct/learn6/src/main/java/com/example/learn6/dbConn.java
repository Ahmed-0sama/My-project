package com.example.learn6;

import java.sql.Connection;
import java.sql.DriverManager;


public class dbConn {
    public static Connection DBConnection() {
        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:MYDB/123@localhost:1521:xe", "OOPDB", "123");
        } catch (Exception e) {
            System.out.println("[!] Error while connecting to the Database");
        }

        return conn;

    }
}
