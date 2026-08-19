package dao;

import database.DatabaseConnection;
import model.Transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TransactionDAO {

    public ArrayList<Transaction> getTransactions(String username) {

        ArrayList<Transaction> transactions =
            new ArrayList<>();

        try {

            Connection connection =
                DatabaseConnection.getConnection();

            
            String incomeSQL =
                "SELECT username, amount, source, date " +
                "FROM income WHERE username = ?";

            PreparedStatement incomeStatement =
                connection.prepareStatement(incomeSQL);

            incomeStatement.setString(1, username);

            ResultSet incomeResult =
                incomeStatement.executeQuery();

            while (incomeResult.next()) {

                Transaction transaction =
                    new Transaction(
                        incomeResult.getString("username"),
                        "Income",
                        incomeResult.getDouble("amount"),
                        incomeResult.getString("source"),
                        incomeResult.getString("date")
                    );

                transactions.add(transaction);
            }


           
            String expenseSQL =
                "SELECT username, amount, category, date " +
                "FROM expense WHERE username = ?";

            PreparedStatement expenseStatement =
                connection.prepareStatement(expenseSQL);

            expenseStatement.setString(1, username);

            ResultSet expenseResult =
                expenseStatement.executeQuery();

            while (expenseResult.next()) {

                Transaction transaction =
                    new Transaction(
                        expenseResult.getString("username"),
                        "Expense",
                        expenseResult.getDouble("amount"),
                        expenseResult.getString("category"),
                        expenseResult.getString("date")
                    );

                transactions.add(transaction);
            }


            incomeResult.close();
            expenseResult.close();

            incomeStatement.close();
            expenseStatement.close();

            connection.close();

        } catch (Exception e) {

            System.out.println(
                "Failed to get transactions!"
            );

            System.out.println(e.getMessage());
        }

        return transactions;
    }
}
