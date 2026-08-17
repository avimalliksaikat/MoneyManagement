package dao;

import database.DatabaseConnection;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserDAO {

    public void registerUser(User user) {

        String sql = "INSERT INTO users (name, username, password) VALUES (?, ?, ?)";

        try {
            Connection connection = DatabaseConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, user.getName());
            statement.setString(2, user.getUsername());
            statement.setString(3, user.getPassword());

            statement.executeUpdate();

            System.out.println("User registered successfully!");

            statement.close();
            connection.close();

        } catch (Exception e) {
            System.out.println("Registration failed!");
            System.out.println(e.getMessage());
        }
    }
    public boolean loginUser(String username, String password) {

    String sql = "SELECT * FROM users WHERE username = ? AND password = ?";

    try {
        Connection connection = DatabaseConnection.getConnection();

        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, username);
        statement.setString(2, password);

        var result = statement.executeQuery();

        if (result.next()) {
            statement.close();
            connection.close();
            return true;
        }

        statement.close();
        connection.close();

    } catch (Exception e) {
        System.out.println("Login failed!");
        System.out.println(e.getMessage());
    }

    return false;
}
}