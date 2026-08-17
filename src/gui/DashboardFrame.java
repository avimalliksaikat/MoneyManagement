package gui;

import java.awt.*;
import java.awt.event.*;

public class DashboardFrame extends Frame {

    public DashboardFrame(String username) {

        setTitle("Money Management - Dashboard");

        setSize(500, 400);

        setLocation(450, 200);

        setLayout(new BorderLayout(10, 10));

        // Welcome message
        Label welcomeLabel = new Label(
            "Welcome, " + username + "!",
            Label.CENTER
        );

        welcomeLabel.setFont(
            new Font("Arial", Font.BOLD, 20)
        );

        add(welcomeLabel, BorderLayout.NORTH);

        // Buttons
        Panel buttonPanel = new Panel();

        buttonPanel.setLayout(
            new GridLayout(4, 1, 10, 10)
        );

        Button incomeButton = new Button("Add Income");

        Button expenseButton = new Button("Add Expense");

        Button transactionButton =
            new Button("View Transactions");

            Button balanceButton =
    new Button("Balance");
        Button logoutButton = new Button("Logout");

        buttonPanel.add(incomeButton);
        buttonPanel.add(expenseButton);
        buttonPanel.add(transactionButton);
        buttonPanel.add(balanceButton);
        buttonPanel.add(logoutButton);

        incomeButton.addActionListener(new ActionListener() {

    public void actionPerformed(ActionEvent e) {

        dispose();

        new IncomeFrame(username);
    }
});

expenseButton.addActionListener(new ActionListener() {

    public void actionPerformed(ActionEvent e) {

        dispose();

        new ExpenseFrame(username);
    }
});
transactionButton.addActionListener(
    new ActionListener() {

        public void actionPerformed(ActionEvent e) {

            dispose();

            new TransactionFrame(username);
        }
    }
);

balanceButton.addActionListener(
    new ActionListener() {

        public void actionPerformed(ActionEvent e) {

            dispose();

            new BalanceFrame(username);
        }
    }
);

        add(buttonPanel, BorderLayout.CENTER);

        // Logout
        logoutButton.addActionListener(
            new ActionListener() {

                public void actionPerformed(ActionEvent e) {

                    dispose();

                    new LoginFrame();
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