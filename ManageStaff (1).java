package coffeeshopsystem;

import javax.swing.*;

public class ManageStaff extends JFrame {

    JTextArea staffArea;

    public ManageStaff() {

        setTitle("Manage Staff");
        setSize(500, 400);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel title = new JLabel("STAFF LIST");
        title.setBounds(200, 20, 150, 30);
        add(title);

        staffArea = new JTextArea();
        staffArea.setBounds(50, 60, 390, 200);
        staffArea.setEditable(false);
        add(staffArea);

        JButton addButton = new JButton("Add Staff");
        addButton.setBounds(100, 290, 120, 35);
        add(addButton);

        JButton closeButton = new JButton("Close");
        closeButton.setBounds(270, 290, 100, 35);
        add(closeButton);

        showStaff();

        addButton.addActionListener(e -> addStaff());

        closeButton.addActionListener(e -> dispose());
    }

    public void showStaff() {

        staffArea.setText("");

        for (user user : data.users) {

            if (user.role.equals("STAFF")) {

                staffArea.append(
                        "Name: " + user.fullName
                        + " | Username: " + user.username
                        + "\n"
                );
            }
        }
    }

    public void addStaff() {

        String name = JOptionPane.showInputDialog(
                this,
                "Staff Name:"
        );

        String username = JOptionPane.showInputDialog(
                this,
                "Username:"
        );

        String password = JOptionPane.showInputDialog(
                this,
                "Password:"
        );

        if (name != null && username != null && password != null) {

            data.users.add(
                    new user(
                            username,
                            password,
                            name,
                            "STAFF"
                    )
            );

            showStaff();
        }
    }
}