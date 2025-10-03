package com.example.employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.InputStream;
import java.io.IOException;

public class DBConnection {
    private static final String PROPS_FILE = "db.properties";

    public static Connection getConnection() throws SQLException, IOException, ClassNotFoundException {
        Properties props = new Properties();

        // Load db.properties from classpath
        try (InputStream input = DBConnection.class.getClassLoader().getResourceAsStream(PROPS_FILE)) {
            if (input == null) {
                throw new IOException("Unable to find " + PROPS_FILE);
            }
            props.load(input);
        }

        String url = props.getProperty("db.url");
        String user = props.getProperty("db.user");
        String pass = props.getProperty("db.password");

        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, user, pass);
    }
}
