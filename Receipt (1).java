package coffeeshopsystem;

import javax.swing.*;

public class Receipt extends JFrame {

    JTextArea receiptArea;

    public Receipt() {  

        setTitle("Receipt");
        setSize(450, 450);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel title = new JLabel("COFFEE SHOP RECEIPT");
        title.setBounds(140, 20, 200, 30);
        add(title);

        receiptArea = new JTextArea();
        receiptArea.setBounds(40, 60, 360, 280);
        receiptArea.setEditable(false);
        add(receiptArea);

        JButton closeButton = new JButton("Close");
        closeButton.setBounds(170, 360, 100, 35);
        add(closeButton);

        showReceipt();

        closeButton.addActionListener(e -> dispose());
    }

    public void showReceipt() {

        receiptArea.setText("");

        if (data.orders.size() == 0) {

            receiptArea.setText("No orders available.");
            return;
        }

        order order =
                data.orders.get(data.orders.size() - 1);

        receiptArea.append(
                "COFFEE SHOP\n"
                + "----------------------------\n"
        );

        receiptArea.append(
                "Customer: "
                + order.customerName
                + "\n"
        );

        receiptArea.append(
                "----------------------------\n"
        );

        for (int i = 0; i < order.products.size(); i++) {

            product product =
                    order.products.get(i);

            int quantity =
                    order.quantities.get(i);

            double subtotal =
                    product.price * quantity;

            receiptArea.append(
                    product.name
                    + " x "
                    + quantity
                    + " = ₱"
                    + subtotal
                    + "\n"
            );
        }

        receiptArea.append(
                "----------------------------\n"
        );

        receiptArea.append(
                "TOTAL: ₱"
                + order.total
                + "\n"
        );

        receiptArea.append(
                "STATUS: "
                + order.status
        );
    }
}