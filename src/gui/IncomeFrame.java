package gui;

import dao.IncomeDAO;
import model.Income;

import java.awt.*;
import java.awt.event.*;

public class IncomeFrame extends Frame {

    private TextField amountField;
    private TextField sourceField;
    private TextField dateField;

    private String username;

    public IncomeFrame(String username) {

        this.username = username;

        setTitle("Money Management - Add Income");

        setSize(400, 300);

        setLocation(500, 250);

        setLayout(new GridLayout(4, 2, 10, 10));

        
        Label amountLabel = new Label("Amount:");

        amountField = new TextField();

        
        Label sourceLabel = new Label("Source:");

        sourceField = new TextField();

        
        Label dateLabel = new Label("Date:");

        dateField = new TextField();

        
        Button addButton = new Button("Add Income");

        Button backButton = new Button("Back");

        
        add(amountLabel);
        add(amountField);

        add(sourceLabel);
        add(sourceField);

        add(dateLabel);
        add(dateField);

        add(addButton);
        add(backButton);


        
        addButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                String amountText = amountField.getText();
                String source = sourceField.getText();
                String date = dateField.getText();

                
                if (amountText.isEmpty() ||
                    source.isEmpty() ||
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

                    Income income = new Income(
                        username,
                        amount,
                        source,
                        date
                    );

                    IncomeDAO incomeDAO =
                        new IncomeDAO();

                    incomeDAO.addIncome(income);

                    showMessage(
                        "Income added successfully!"
                    );

                    amountField.setText("");
                    sourceField.setText("");
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
            IncomeFrame.this,
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
