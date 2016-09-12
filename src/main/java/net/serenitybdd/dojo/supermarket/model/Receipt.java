package net.serenitybdd.dojo.supermarket.model;

import java.util.concurrent.atomic.AtomicInteger;

public class Receipt {

    public static AtomicInteger number = new AtomicInteger();
    public double totalBillAmount = 0.00;
    public int receiptNumber;
    private static double calculatedAmount = 0.00;
    private Products productsPurchased;

    public Receipt(int receiptNumber, double totalBillAmount, Products productsPurchased) {
        this.receiptNumber = receiptNumber;
        this.totalBillAmount = totalBillAmount;
        this.productsPurchased = productsPurchased;
    }

    public Receipt() {
        //To change body of created methods use File | Settings | File Templates.
    }

    public double getTotalBillAmount() {
        return totalBillAmount;
    }

    public static Receipt calculateBillFor(ShoppingCart theCart) {
        if (theCart.getProducts() != null) {
            Products productsInCart = theCart.getProducts();
            calculatedAmount = productsInCart.getPrice() * theCart.getQuantity();
            return new Receipt(number.incrementAndGet(), calculatedAmount, productsInCart);  //To change body of created methods use File | Settings | File Templates.
        } else
            return new Receipt();
    }

    public static Receipt calculateDiscountedBillFor(ShoppingCart theCart) {
        if (theCart.getProducts() != null) {
            Products productsInCart = theCart.getProducts();
            if ("Apples" == theCart.getProducts().toString() && theCart.getQuantity() > 10) {
                calculatedAmount = productsInCart.getPrice() * theCart.getQuantity();
                double discountPrice = 0.2 * calculatedAmount;
                calculatedAmount -= discountPrice;
                return new Receipt(number.incrementAndGet(),calculatedAmount, productsInCart);
            } else
                return new Receipt();
        } else
            return new Receipt();
    }

    public Products getProductsPurchased() {
        return productsPurchased;
    }
}
