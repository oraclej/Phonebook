package shalbaf.phonebook.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingleConnection {
    private static SingleConnection singleConnection = new SingleConnection();
    private Connection connection;


    private SingleConnection() {
        String jdbcURL = "jdbc:mysql://localhost:3306/contacts";
        String username = "arash";
        String password = "1234";
        try {
            connection = DriverManager.getConnection(jdbcURL, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static SingleConnection getSingleConnection() {
        return singleConnection;
    }

    public Connection getConnection() {
        return connection;
    }
}
