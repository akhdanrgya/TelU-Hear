package com.tubespbo.tubes.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    private Connection connection;

    public UserDAO() {
        databaseConnection.connect();
        this.connection = databaseConnection.getConnection();
    }

    public boolean validateUser(String username, String password) {
        String query = "SELECT * FROM users WHERE username = ? AND password = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet resultSet = stmt.executeQuery();

            return resultSet.next();
        } catch (SQLException e) {
            System.err.println("Error saat validasi user: " + e.getMessage());
            return false;
        }
    }
    
public void register(String username, String password, int role) {
    String query = "INSERT INTO `users` (`username`, `password`, `role`) VALUES (?, ?, ?)";
    try (PreparedStatement stmt = connection.prepareStatement(query)) {
        stmt.setString(1, username);
        stmt.setString(2, password);
        stmt.setInt(3, role);
        int rowsInserted = stmt.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("Akun berhasil dibuat!");
        } else {
            System.out.println("Gagal membuat akun!");
        }
    } catch (SQLException e) {
        System.out.println("Error saat membuat akun: " + e.getMessage());
    }
}

}
