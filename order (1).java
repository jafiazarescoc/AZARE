package coffeeshopsystem;

import java.util.ArrayList;

public class order {

    String customerName;
    ArrayList<product> products;
    ArrayList<Integer> quantities;
    double total;
    String status;

    public order(String customerName) {
        this.customerName = customerName;
        this.products = new ArrayList<>();
        this.quantities = new ArrayList<>();
        this.total = 0;
        this.status = "Pending";
    }

    public void addProduct(product product, int quantity) {

        products.add(product);
        quantities.add(quantity);

        total = total + (product.price * quantity);
    }
}