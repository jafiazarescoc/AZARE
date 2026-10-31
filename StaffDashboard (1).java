package coffeeshopsystem;

import javax.swing.*;

public class StaffDashboard extends JFrame {

    user staff;

    public StaffDashboard(user staff) {

        this.staff = staff;

        setTitle("Staff Dashboard");
        setSize(500, 400);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel title = new JLabel("STAFF DASHBOARD");
        title.setBounds(180, 30, 200, 30);
        add(title);

        JLabel welcome = new JLabel("Welcome, " + staff.fullName);
        welcome.setBounds(170, 60, 250, 30);
        add(welcome);

        JButton orderButton = new JButton("New Order");
        orderButton.setBounds(150, 110, 200, 40);
        add(orderButton);

        JButton productButton = new JButton("View Products");
        productButton.setBounds(150, 160, 200, 40);
        add(productButton);

        JButton ordersButton = new JButton("View Orders");
        ordersButton.setBounds(150, 210, 200, 40);
        add(ordersButton);

        JButton receiptButton = new JButton("Receipt");
        receiptButton.setBounds(150, 260, 200, 40);
        add(receiptButton);

        JButton logoutButton = new JButton("Logout");
        logoutButton.setBounds(190, 320, 120, 35);
        add(logoutButton);

        orderButton.addActionListener(e ->
                new NewOrder(staff).setVisible(true));

        productButton.addActionListener(e ->
                new ManageProducts().setVisible(true));

        ordersButton.addActionListener(e ->
                new ManageOrders().setVisible(true));

        receiptButton.addActionListener(e ->
                new Receipt().setVisible(true));

        logoutButton.addActionListener(e -> {
            new login().setVisible(true);
            dispose();
        });
    }
}