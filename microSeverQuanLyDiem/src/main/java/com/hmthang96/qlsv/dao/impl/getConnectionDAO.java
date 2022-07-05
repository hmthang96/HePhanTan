package com.hmthang96.qlsv.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class getConnectionDAO {
    public Connection getConnectionDAO() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/studentdb";
            String user = "root";
            String password = "Missroine12";
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            return null;
        }
    }
}