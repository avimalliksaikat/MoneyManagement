package gui;

import dao.UserDAO;

import java.awt.*;
import java.awt.event.*;

public class LoginFrame extends Frame {

    private TextField usernameField;
    private TextField passwordField;

    public LoginFrame() {

        // Window title
        setTitle("Money Management - Login");

        // Window size
        setSize(400, 300);

        // Window position
        setLocation(500, 250);

        // Layout
        setLayout(new GridLayout(4, 2, 10, 10));

        // Username
        Label usernameLabel = new Label("Username:");
        usernameField = new TextField();

        // Password
        Label passwordLabel = new Label("Password:");
        passwordField = new TextField();

        // Hide password
        passwordField.setEchoChar('*');

        // Login button
        Button loginButton = new Button("Login");

        // Register button
        Button registerButton = new Button("Register");

        // Add components
        add(usernameLabel);
        add(usernameField);

        add(passwordLabel);
        add(passwordField);

        add(loginButton);
        add(registerButton);


        // Login button action
        loginButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                String username = usernameField.getText();
                String password = passwordField.getText();

                UserDAO userDAO = new UserDAO();

                boolean result =
                    userDAO.loginUser(username, password);


                if (result) {

                    // Close login window
                    dispose();

                    // Open dashboard
                    new DashboardFrame(username);

                } else {

                    // Error message
                    Dialog dialog = new Dialog(
                        LoginFrame.this,
                        "Error",
                        true
                    );

                    dialog.setLayout(new FlowLayout());

                    Label message =
                        new Label("Invalid username or password!");

                    Button okButton =
                        new Button("OK");

                    okButton.addActionListener(
                        new ActionListener() {

                            public void actionPerformed(
                                ActionEvent e) {

                                dialog.dispose();
                            }
                        }
                    );

                    dialog.add(message);
                    dialog.add(okButton);

                    dialog.setSize(300, 120);

                    dialog.setLocation(550, 350);

                    dialog.setVisible(true);
                }
            }
        });


        // Register button action
        registerButton.addActionListener(
            new ActionListener() {

                public void actionPerformed(ActionEvent e) {

                    // Close login window
                    dispose();

                    // Open registration window
                    new RegisterFrame();
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


        // Show window
        setVisible(true);
    }
}