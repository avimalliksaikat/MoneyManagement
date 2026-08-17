package gui;

import dao.ExpenseDAO;
import model.Expense;

import java.awt.*;
import java.awt.event.*;

public class ExpenseFrame extends Frame {

    private TextField amountField;
    private TextField categoryField;
    private TextField dateField;

    private String username;

    public ExpenseFrame(String username) {

        this.username = username;

        setTitle("Money Management - Add Expense");

        setSize(400, 300);

        setLocation(500, 250);

        setLayout(new GridLayout(4, 2, 10, 10));

        // Amount
        Label amountLabel = new Label("Amount:");
        amountField = new TextField();

        // Category
        Label categoryLabel = new Label("Category:");
        categoryField = new TextField();

        // Date
        Label dateLabel = new Label("Date:");
        dateField = new TextField();

        // Buttons
        Button addButton = new Button("Add Expense");
        Button backButton = new Button("Back");

        // Add components
        add(amountLabel);
        add(amountField);

        add(categoryLabel);
        add(categoryField);

        add(dateLabel);
        add(dateField);

        add(addButton);
        add(backButton);


        // Add Expense button
        addButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                String amountText = amountField.getText();
                String category = categoryField.getText();
                String date = dateField.getText();

                // Check empty fields
                if (amountText.isEmpty() ||
                    category.isEmpty() ||
                    date.isEmpty()) {

                    showMessage("Please fill all fields!");

                    return;
                }

                try {

                    double amount =
                        Double.parseDouble(amountText);

                    if (amount <= 0) {

                        showMessage(
                            "Amount must be greater than 0!"
                        );

                        return;
                    }

                    Expense expense = new Expense(
                        username,
                        amount,
                        category,
                        date
                    );

                    ExpenseDAO expenseDAO =
                        new ExpenseDAO();

                    expenseDAO.addExpense(expense);

                    showMessage(
                        "Expense added successfully!"
                    );

                    amountField.setText("");
                    categoryField.setText("");
                    dateField.setText("");

                } catch (NumberFormatException ex) {

                    showMessage(
                        "Please enter a valid amount!"
                    );
                }
            }
        });


        // Back button
        backButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                dispose();

                new DashboardFrame(username);
            }
        });


        // Close window
        addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {

                dispose();
            }
        });

        setVisible(true);
    }


    // Message dialog
    private void showMessage(String message) {

        Dialog dialog = new Dialog(
            ExpenseFrame.this,
            "Message",
            true
        );

        dialog.setLayout(new FlowLayout());

        Label label = new Label(message);

        Button okButton = new Button("OK");

        okButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                dialog.dispose();
            }
        });

        dialog.add(label);
        dialog.add(okButton);

        dialog.setSize(300, 120);

        dialog.setLocation(550, 350);

        dialog.setVisible(true);
    }
}