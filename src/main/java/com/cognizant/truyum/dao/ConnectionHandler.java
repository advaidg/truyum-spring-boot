package com.cognizant.truyum.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionHandler {

    private static final Connection connection;
    private static Properties props = new Properties();

    static {
        Connection conn = null;
        try (FileInputStream fis = new FileInputStream(
                "C:\\Users\\Advaid Gireesan\\Documents\\truyumspringmvc (2)\\truyum-spring-mvc\\src\\main\\resources\\connection.properties")) {
            props.load(fis);
            Class.forName(props.getProperty("driver"));
            conn = DriverManager.getConnection(props.getProperty("connection-url"), props.getProperty("user"),
                    props.getProperty("password"));
        } catch (IOException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        connection = conn;
    }

    private ConnectionHandler() {
    }

    public static Connection getConnection() {
        return connection;
    }
}
