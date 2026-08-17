package dao;

import database.DatabaseConnection;
import model.Expense;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ExpenseDAO {

    public void addExpense(Expense expense) {

        String sql = "INSERT INTO expense " +
                     "(username, amount, category, date) " +
                     "VALUES (?, ?, ?, ?)";

        try {

            Connection connection =
                DatabaseConnection.getConnection();

            PreparedStatement statement =
                connection.prepareStatement(sql);

            statement.setString(1, expense.getUsername());
            statement.setDouble(2, expense.getAmount());
            statement.setString(3, expense.getCategory());
            statement.setString(4, expense.getDate());

            statement.executeUpdate();

            System.out.println("Expense added successfully!");

            statement.close();
            connection.close();

        } catch (Exception e) {

            System.out.println("Failed to add expense!");
            System.out.println(e.getMessage());
        }
    }
}