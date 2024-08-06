package com.cognizant.truyum.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionHandler {

    // Make connection a static final constant
    private static final Connection connection;

    // Initialize connection in a static block
    static {
        Connection conn = null;
        // Make props a private static final constant
        private static final Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream(
                "C:\\Users\\Advaid Gireesan\\Documents\\truyumspringmvc (2)\\truyum-spring-mvc\\src\\main\\resources\\connection.properties")) { // Use try-with-resources for FileInputStream
            props.load(fis);
            Class.forName(props.getProperty("driver"));
            conn = DriverManager.getConnection(props.getProperty("connection-url"), props.getProperty("user"),
                    props.getProperty("password"));
        } catch (IOException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        connection = conn; // Assign the initialized connection to the final variable
    }

    // Add a private constructor to hide the implicit public one
    private ConnectionHandler() {
    }

    // Provide a public static accessor for the connection
    public static Connection getConnection() {
        return connection;
    }
}
