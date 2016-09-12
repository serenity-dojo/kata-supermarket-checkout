package net.serenitybdd.dojo.supermarket;

import net.serenitybdd.dojo.supermarket.model.*;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class WhenCheckingOutArticlesAtTheSupermarket {

    @Test
    public void an_empty_shopping_cart_should_cost_nothing() {
        SupermarketCatalog catalog = new WeekdayDealsCatalog();
        Teller teller = new Teller(catalog);

        // GIVEN
        ShoppingCart theCartOfVikrant = new ShoppingCart();

        // WHEN
        Receipt receipt = teller.checksOutArticlesFrom(theCartOfVikrant);

        // THEN
        assertThat(receipt.getTotalBillAmount(), equalTo(0.00));
        assertThat(theCartOfVikrant.isEmpty(), is(equalTo(true)));
    }

    @Test
    public void should_be_able_to_handle_shopping_cart_with_no_special_deals() {
        // GIVEN
        SupermarketCatalog catalog = new WeekdayDealsCatalog();
        Teller teller = new Teller(catalog);
        ShoppingCart theCartOfVikrant = ShoppingCart.add(Products.Apples).withQuantity(11);

        //WHEN
        Receipt receipt = teller.checksOutArticlesFrom(theCartOfVikrant);

        // THEN
        //assertThat(receipt.getTotalBillAmount(), equalTo(33.00));
        assertThat(receipt.receiptNumber, is(notNullValue()));
        assertThat(theCartOfVikrant.isEmpty(), is(equalTo(false)));
    }

    @Test
    public void should_get_receipt_with_the_list_of_purchases_and_the_total_price() {
        // GIVEN
        SupermarketCatalog catalog = new WeekdayDealsCatalog();
        Teller teller = new Teller(catalog);
        ShoppingCart theCartOfVikrant = ShoppingCart.add(Products.Apples).withQuantity(11);

        //WHEN
        Receipt receipt = teller.checksOutArticlesFrom(theCartOfVikrant);

        // THEN
        assertThat(receipt.receiptNumber, is(notNullValue()));
        assertThat(receipt.getTotalBillAmount(), equalTo(33.00));
        assertThat(receipt.getProductsPurchased(), equalTo(theCartOfVikrant.getProducts()));
    }

    @Test
    public void should_be_able_to_handle_shopping_cart_with_20Percent_deals_if_cart_has_more_than_10_products() {
        // GIVEN
        SupermarketCatalog catalog = new WeekendDealsCatalog();
        Teller teller = new Teller(catalog);
        ShoppingCart theCartOfVikrant = ShoppingCart.add(Products.Apples).withQuantity(11);

        //WHEN
        Receipt receipt = teller.checksOutArticlesFrom(theCartOfVikrant);

        // THEN
        assertThat(receipt.receiptNumber, is(notNullValue()));
        assertThat(receipt.getTotalBillAmount(), equalTo(26.40));
        assertThat(receipt.getProductsPurchased(), equalTo(theCartOfVikrant.getProducts()));
    }


}
