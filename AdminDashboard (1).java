package coffeeshopsystem;

import javax.swing.*;

public class AdminDashboard extends JFrame {

    user admin;

    public AdminDashboard(user admin) {

        this.admin = admin;

        setTitle("Admin Dashboard");
        setSize(500, 450);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel title = new JLabel("ADMIN DASHBOARD");
        title.setBounds(180, 30, 200, 30);
        add(title);

        JLabel welcome = new JLabel("Welcome, " + admin.fullName);
        welcome.setBounds(170, 60, 250, 30);
        add(welcome);

        JButton staffButton = new JButton("Manage Staff");
        staffButton.setBounds(150, 100, 200, 40);
        add(staffButton);

        JButton customerButton = new JButton("Manage Customers");
        customerButton.setBounds(150, 150, 200, 40);
        add(customerButton);

        JButton productButton = new JButton("Manage Products");
        productButton.setBounds(150, 200, 200, 40);
        add(productButton);

        JButton orderButton = new JButton("Manage Orders");
        orderButton.setBounds(150, 250, 200, 40);
        add(orderButton);

        JButton salesButton = new JButton("Sales Report");
        salesButton.setBounds(150, 300, 200, 40);
        add(salesButton);

        JButton logoutButton = new JButton("Logout");
        logoutButton.setBounds(190, 360, 120, 35);
        add(logoutButton);

        staffButton.addActionListener(e ->
                new ManageStaff().setVisible(true));

        customerButton.addActionListener(e ->
                new ManageCustomers().setVisible(true));

        productButton.addActionListener(e ->
                new ManageProducts().setVisible(true));

        orderButton.addActionListener(e ->
                new ManageOrders().setVisible(true));

        salesButton.addActionListener(e ->
                new SalesReport().setVisible(true));

        logoutButton.addActionListener(e -> logout());
    }

    public void logout() {

        new login().setVisible(true);
        dispose();
    }
}