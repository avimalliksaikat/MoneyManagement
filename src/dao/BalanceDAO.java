package dao;

import database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BalanceDAO {

    public double getTotalIncome(String username) {

        double totalIncome = 0;

        String sql = "SELECT SUM(amount) FROM income " +
                     "WHERE username = ?";

        try {

            Connection connection =
                DatabaseConnection.getConnection();

            PreparedStatement statement =
                connection.prepareStatement(sql);

            statement.setString(1, username);

            ResultSet result =
                statement.executeQuery();

            if (result.next()) {

                totalIncome = result.getDouble(1);
            }

            result.close();
            statement.close();
            connection.close();

        } catch (Exception e) {

            System.out.println("Failed to get income!");
            System.out.println(e.getMessage());
        }

        return totalIncome;
    }


    public double getTotalExpense(String username) {

        double totalExpense = 0;

        String sql = "SELECT SUM(amount) FROM expense " +
                     "WHERE username = ?";

        try {

            Connection connection =
                DatabaseConnection.getConnection();

            PreparedStatement statement =
                connection.prepareStatement(sql);

            statement.setString(1, username);

            ResultSet result =
                statement.executeQuery();

            if (result.next()) {

                totalExpense = result.getDouble(1);
            }

            result.close();
            statement.close();
            connection.close();

        } catch (Exception e) {

            System.out.println("Failed to get expense!");
            System.out.println(e.getMessage());
        }

        return totalExpense;
    }


    public double getBalance(String username) {

        double income =
            getTotalIncome(username);

        double expense =
            getTotalExpense(username);

        return income - expense;
    }
}