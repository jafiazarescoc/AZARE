package coffeeshopsystem;

import javax.swing.*;

public class Register extends JFrame {

    JTextField usernameField;
    JPasswordField passwordField;
    JTextField nameField;

    public Register() {

        setTitle("Customer Registration");
        setSize(400, 350);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel title = new JLabel("CUSTOMER REGISTRATION");
        title.setBounds(110, 25, 200, 30);
        add(title);

        JLabel nameLabel = new JLabel("Full Name:");
        nameLabel.setBounds(50, 75, 100, 30);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(150, 75, 180, 30);
        add(nameField);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(50, 115, 100, 30);
        add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(150, 115, 180, 30);
        add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 155, 100, 30);
        add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 155, 180, 30);
        add(passwordField);

        JButton registerButton = new JButton("REGISTER");
        registerButton.setBounds(130, 205, 130, 30);
        add(registerButton);

        JButton backButton = new JButton("BACK");
        backButton.setBounds(150, 245, 90, 30);
        add(backButton);

        registerButton.addActionListener(e -> register());

        backButton.addActionListener(e -> {
            new login().setVisible(true);
            dispose();
        });
    }

    public void register() {

        String name = nameField.getText();
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        if (name.isEmpty() || username.isEmpty() || password.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please fill in all fields."
            );

            return;
        }

        for (user user : data.users) {

            if (user.username.equals(username)) {

                JOptionPane.showMessageDialog(
                        this,
                        "Username already exists."
                );

                return;
            }
        }

        data.users.add(
                new user(
                        username,
                        password,
                        name,
                        "CUSTOMER"
                )
        );

        JOptionPane.showMessageDialog(
                this,
                "Registration successful!"
        );

        new login().setVisible(true);
        dispose();
    }
}