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

        
        Label amountLabel = new Label("Amount:");
        amountField = new TextField();

        
        Label categoryLabel = new Label("Category:");
        categoryField = new TextField();

        
        Label dateLabel = new Label("Date:");
        dateField = new TextField();

        
        Button addButton = new Button("Add Expense");
        Button backButton = new Button("Back");

        
        add(amountLabel);
        add(amountField);

        add(categoryLabel);
        add(categoryField);

        add(dateLabel);
        add(dateField);

        add(addButton);
        add(backButton);


        
        addButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                String amountText = amountField.getText();
                String category = categoryField.getText();
                String date = dateField.getText();

                
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


        
        backButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                dispose();

                new DashboardFrame(username);
            }
        });


    
        addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {

                dispose();
            }
        });

        setVisible(true);
    }


    
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
