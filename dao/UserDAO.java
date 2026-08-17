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
}