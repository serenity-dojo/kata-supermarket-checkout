package net.serenitybdd.dojo.supermarket.model;

import java.util.ArrayList;
import java.util.Collection;

public class ShoppingCart {

    private Products products;
    private int quantity;
    private double totalPrice;

    private static final Collection productsAddedInCart = new ArrayList<>();

    public ShoppingCart() {
    }

    public ShoppingCart(Products products, int quantity, double totalPrice) {
        this.products = products;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public boolean isEmpty() {
        return productsAddedInCart.isEmpty();
    }

    public static ShoppingCartBuilder add(Products products) {
        productsAddedInCart.add(products);
        return new ShoppingCartBuilder(products);
    }

    public Products getProducts() {
        return products;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public static class ShoppingCartBuilder {
        private Products products;
        private double totalPrice;

        public ShoppingCartBuilder(Products products) {
            this.products = products;
        }

        public ShoppingCart withQuantity(int quantity) {
            return new ShoppingCart(products, quantity, totalPrice);
        }
    }

    @Override
    public String toString() {
        return "" + products;
    }
}
