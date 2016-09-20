package net.serenitybdd.dojo.supermarket.model;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private final List<Product> items = new ArrayList<>();

    public List<Product> getItems() {
        return new ArrayList<>(items);
    }

    public void addItem(Product product) {
        items.add(product);
    }

    public ShoppingCartAdder add(Product product) {
        return new ShoppingCartAdder(this, product);
    }

    public class ShoppingCartAdder {
        private final ShoppingCart shoppingCart;
        private final Product product;

        public ShoppingCartAdder(ShoppingCart shoppingCart, Product product) {
            this.shoppingCart = shoppingCart;
            this.product = product;
        }

        public void times(int quantity) {
            for(int count = 0; count < quantity; count++) {
                shoppingCart.addItem(product);
            }
        }
    }
}
