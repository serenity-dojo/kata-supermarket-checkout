package net.serenitybdd.dojo.supermarket.model;

import java.util.Collection;

public interface SupermarketCatalog {

    public Receipt checkOut(ShoppingCart theCart);
}
