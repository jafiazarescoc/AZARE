package coffeeshopsystem;

import javax.swing.*;

public class ManageProducts extends JFrame {

    JTextArea productArea;

    public ManageProducts() {

        setTitle("Manage Products");
        setSize(500, 450);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel title = new JLabel("PRODUCT MENU");
        title.setBounds(190, 20, 150, 30);
        add(title);

        productArea = new JTextArea();
        productArea.setBounds(40, 60, 410, 250);
        productArea.setEditable(false);
        add(productArea);

        JButton addButton = new JButton("Add Product");
        addButton.setBounds(80, 340, 130, 35);
        add(addButton);

        JButton closeButton = new JButton("Close");
        closeButton.setBounds(280, 340, 100, 35);
        add(closeButton);

        showProducts();

        addButton.addActionListener(e -> addProduct());

        closeButton.addActionListener(e -> dispose());
    }

    public void showProducts() {

        productArea.setText("");

        int number = 1;

        for (product product : data.products) {

            productArea.append(
                    number + ". "
                    + product.name
                    + " - "
                    + product.category
                    + " - ₱"
                    + product.price
                    + "\n"
            );

            number++;
        }
    }

    public void addProduct() {

        String name = JOptionPane.showInputDialog(
                this,
                "Product Name:"
        );

        String category = JOptionPane.showInputDialog(
                this,
                "Category:"
        );

        String priceText = JOptionPane.showInputDialog(
                this,
                "Price:"
        );

        try {

            double price = Double.parseDouble(priceText);

            data.products.add(
                    new product(name, category, price)
            );

            showProducts();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Invalid price."
            );
        }
    }
}