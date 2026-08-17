package dao;

import database.DatabaseConnection;
import model.Income;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class IncomeDAO {

    public void addIncome(Income income) {

        String sql = "INSERT INTO income " +
                     "(username, amount, source, date) " +
                     "VALUES (?, ?, ?, ?)";

        try {

            Connection connection =
                DatabaseConnection.getConnection();

            PreparedStatement statement =
                connection.prepareStatement(sql);

            statement.setString(1, income.getUsername());
            statement.setDouble(2, income.getAmount());
            statement.setString(3, income.getSource());
            statement.setString(4, income.getDate());

            statement.executeUpdate();

            System.out.println("Income added successfully!");

            statement.close();
            connection.close();

        } catch (Exception e) {

            System.out.println("Failed to add income!");
            System.out.println(e.getMessage());
        }
    }
}