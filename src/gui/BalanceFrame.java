package gui;

import dao.BalanceDAO;

import java.awt.*;
import java.awt.event.*;

public class BalanceFrame extends Frame {

    private String username;

    public BalanceFrame(String username) {

        this.username = username;

        setTitle("Money Management - Balance");

        setSize(400, 300);

        setLocation(500, 250);

        setLayout(new GridLayout(5, 2, 10, 10));


        // Create BalanceDAO
        BalanceDAO balanceDAO =
            new BalanceDAO();


        // Get values from database
        double totalIncome =
            balanceDAO.getTotalIncome(username);

        double totalExpense =
            balanceDAO.getTotalExpense(username);

        double balance =
            balanceDAO.getBalance(username);


        // Labels
        Label incomeLabel =
            new Label("Total Income:");

        Label incomeValue =
            new Label(String.format("%.2f", totalIncome));


        Label expenseLabel =
            new Label("Total Expense:");

        Label expenseValue =
            new Label(String.format("%.2f", totalExpense));


        Label balanceLabel =
            new Label("Balance:");

        Label balanceValue =
            new Label(String.format("%.2f", balance));


        // Back button
        Button backButton =
            new Button("Back");


        // Add components
        add(incomeLabel);
        add(incomeValue);

        add(expenseLabel);
        add(expenseValue);

        add(balanceLabel);
        add(balanceValue);

        // Empty spaces
        add(new Label(""));
        add(new Label(""));

        add(new Label(""));
        add(backButton);


        // Back button action
        backButton.addActionListener(
            new ActionListener() {

                public void actionPerformed(ActionEvent e) {

                    dispose();

                    new DashboardFrame(username);
                }
            }
        );


        // Close window
        addWindowListener(
            new WindowAdapter() {

                public void windowClosing(WindowEvent e) {

                    dispose();
                }
            }
        );


        setVisible(true);
    }
}