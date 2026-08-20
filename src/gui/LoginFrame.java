package gui;

import dao.UserDAO;

import java.awt.*;
import java.awt.event.*;

public class LoginFrame extends Frame {

    private TextField usernameField;
    private TextField passwordField;

    public LoginFrame() {

        
        setTitle("Money Management - Login");

        
        setSize(400, 300);

        
        setLocation(500, 250);

        
        setLayout(new GridLayout(4, 2, 10, 10));

        
        Label usernameLabel = new Label("Username:");
        usernameField = new TextField();

        
        Label passwordLabel = new Label("Password:");
        passwordField = new TextField();

        
        passwordField.setEchoChar('*');

        
        Button loginButton = new Button("Login");

        
        Button registerButton = new Button("Register");

       
        add(usernameLabel);
        add(usernameField);

        add(passwordLabel);
        add(passwordField);

        add(loginButton);
        add(registerButton);


       
        loginButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                String username = usernameField.getText();
                String password = passwordField.getText();

                UserDAO userDAO = new UserDAO();

                boolean result =
                    userDAO.loginUser(username, password);


                if (result) {

                   
                    dispose();

                    
                    new DashboardFrame(username);

                } else {

                 
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


        
        registerButton.addActionListener(
            new ActionListener() {

                public void actionPerformed(ActionEvent e) {

                   
                    dispose();

                   
                    new RegisterFrame();
                }
            }
        );


    
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
