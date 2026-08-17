package gui;

import dao.TransactionDAO;
import model.Transaction;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class TransactionFrame extends Frame {

    private String username;

    public TransactionFrame(String username) {

        this.username = username;

        setTitle("Money Management - Transactions");

        setSize(700, 400);

        setLocation(350, 200);

        setLayout(new BorderLayout(10, 10));


        // Title
        Label titleLabel =
            new Label("My Transactions", Label.CENTER);

        titleLabel.setFont(
            new Font("Arial", Font.BOLD, 20)
        );

        add(titleLabel, BorderLayout.NORTH);


        // Text area
        TextArea transactionArea =
            new TextArea();

        transactionArea.setEditable(false);

        add(transactionArea, BorderLayout.CENTER);


        // Get transactions
        TransactionDAO transactionDAO =
            new TransactionDAO();

        ArrayList<Transaction> transactions =
            transactionDAO.getTransactions(username);


        // Display heading
        transactionArea.append(
            "Type\tAmount\tDescription\tDate\n"
        );

        transactionArea.append(
            "--------------------------------------------------\n"
        );


        // Display transactions
        for (Transaction transaction : transactions) {

            transactionArea.append(
                transaction.getType()
                + "\t"
                + transaction.getAmount()
                + "\t"
                + transaction.getDescription()
                + "\t"
                + transaction.getDate()
                + "\n"
            );
        }


        // If no transactions
        if (transactions.isEmpty()) {

            transactionArea.append(
                "\nNo transactions found."
            );
        }


        // Back button
        Button backButton =
            new Button("Back");

        add(backButton, BorderLayout.SOUTH);


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