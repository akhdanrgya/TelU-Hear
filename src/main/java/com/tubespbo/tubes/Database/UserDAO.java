package com.tubespbo.tubes.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    private Connection connection;

    public UserDAO() {
        databaseConnection.connect(); // connect ke database
        this.connection = databaseConnection.getConnection();
    }

    public boolean validateUser(String username, String password) {
        String query = "SELECT * FROM users WHERE username = ? AND password = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet resultSet = stmt.executeQuery();

            return resultSet.next(); // true kalau user ada di database
        } catch (SQLException e) {
            System.err.println("Error saat validasi user: " + e.getMessage());
            return false;
        }
    }
}
