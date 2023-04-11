package org.example.infrastructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class dbmsConnection {
    String username = "root";
    String password = "Mahdi840";
    String url = "jdbc:mysql://localhost:3306/shop";

    public dbmsConnection() {
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(this.url, this.username, this.password);
            return connection;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void closeConnection(Connection connection, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.close();
        connection.close();
    }
}
