package net.serenitybdd.dojo.supermarket.model;

import java.util.concurrent.atomic.AtomicLong;

public class Receipt {

    public AtomicLong paymentNumber;
    public static double totalPrice = 0.00;
    private Products productsInCart;

    public Receipt(double totalPrice, Products productsInCart) {
        this.totalPrice = totalPrice;
        this.productsInCart = productsInCart;
    }

    public Receipt() {
        //To change body of created methods use File | Settings | File Templates.
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public static Receipt calculateBillFor(ShoppingCart theCart) {
        if (theCart.getProducts() != null) {
            Products productsInCart = theCart.getProducts();

            totalPrice += productsInCart.getPrice() * theCart.getQuantity();

            return new Receipt(totalPrice, productsInCart);  //To change body of created methods use File | Settings | File Templates.
        } else
            return new Receipt();
    }

    public static Receipt calculateDiscountedBillFor(ShoppingCart theCart) {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }
}
