package com.projetCC.DataBaseService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnector {

    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    private static MySqlConnector instance;

    public static MySqlConnector getInstance() {
        if (instance == null) {
            instance = new MySqlConnector();
        }

        return instance;
    }

    private MySqlConnector() {
        String url = "jdbc:mysql://localhost:3306/projetcci_nk";

        try{
            connection = DriverManager.getConnection(url, "root", "root");
        } catch (SQLException e) {
            // Is the SQL server running ?
            System.err.println("Database connection error");
            System.err.println(e.getMessage());
        }
    }
}
