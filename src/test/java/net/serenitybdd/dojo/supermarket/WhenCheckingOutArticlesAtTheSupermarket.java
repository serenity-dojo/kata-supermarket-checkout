package net.serenitybdd.dojo.supermarket;

import net.serenitybdd.dojo.supermarket.model.*;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class WhenCheckingOutArticlesAtTheSupermarket {

    private SupermarketCatalog catalog;
    private Teller teller;

    @Before
    public void setup() {
        catalog = new WeekendDealsCatalog();
        teller = new Teller(catalog);
    }

    @Test
    public void an_empty_shopping_cart_should_cost_nothing() {
        // GIVEN
        ShoppingCart theCartOfVikrant = new ShoppingCart();

        // WHEN
        Receipt receipt = teller.checksOutArticlesFrom(theCartOfVikrant);

        // THEN
        assertThat(receipt.getTotalPrice(), equalTo(0.00));
        assertThat(theCartOfVikrant.isEmpty(), is(equalTo(true)));
    }

    @Test
    public void shopping_cart_should_be_able_to_add_products() {
        // GIVEN
        ShoppingCart theCartOfVikrant = ShoppingCart.add(Products.Apples).withQuantity(11);

        //WHEN
        Receipt receipt = teller.checksOutArticlesFrom(theCartOfVikrant);

        // THEN
        assertThat(receipt.getTotalPrice(), equalTo(33.00));
        assertThat(theCartOfVikrant.isEmpty(), is(equalTo(false)));

    }
}
