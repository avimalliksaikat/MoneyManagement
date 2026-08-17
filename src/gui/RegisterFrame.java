package gui;

import dao.UserDAO;
import model.User;

import java.awt.*;
import java.awt.event.*;

public class RegisterFrame extends Frame {

    private TextField nameField;
    private TextField usernameField;
    private TextField passwordField;

    public RegisterFrame() {

        setTitle("Money Management - Registration");

        setSize(400, 300);

        setLocation(500, 250);

        setLayout(new GridLayout(5, 2, 10, 10));

        // Name
        Label nameLabel = new Label("Name:");
        nameField = new TextField();

        // Username
        Label usernameLabel = new Label("Username:");
        usernameField = new TextField();

        // Password
        Label passwordLabel = new Label("Password:");
        passwordField = new TextField();

        passwordField.setEchoChar('*');

        // Register button
        Button registerButton = new Button("Register");

        // Back button
        Button backButton = new Button("Back");

        // Add components
        add(nameLabel);
        add(nameField);

        add(usernameLabel);
        add(usernameField);

        add(passwordLabel);
        add(passwordField);

        add(registerButton);
        add(backButton);

        // Register button
        registerButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                String name = nameField.getText();
                String username = usernameField.getText();
                String password = passwordField.getText();

                if (name.isEmpty() ||
                    username.isEmpty() ||
                    password.isEmpty()) {

                    showMessage("Please fill all fields!");

                    return;
                }

                User user = new User(
                    name,
                    username,
                    password
                );

                UserDAO userDAO = new UserDAO();

                userDAO.registerUser(user);

                showMessage("Registration successful!");

                nameField.setText("");
                usernameField.setText("");
                passwordField.setText("");
            }
        });

        // Back button
        backButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                dispose();

                new LoginFrame();
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

    // Simple message dialog
    private void showMessage(String message) {

        Dialog dialog = new Dialog(
            RegisterFrame.this,
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