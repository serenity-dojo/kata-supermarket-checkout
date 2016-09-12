package net.serenitybdd.dojo.supermarket.model;

import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: vdheer
 * Date: 9/6/16
 * Time: 9:44 AM
 * To change this template use File | Settings | File Templates.
 */
public class WeekdayDealsCatalog implements SupermarketCatalog {
    @Override
    public Receipt checkOut(ShoppingCart theCart) {
        return Receipt.calculateBillFor(theCart);
    }
}
