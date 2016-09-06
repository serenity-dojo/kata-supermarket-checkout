package net.serenitybdd.dojo.supermarket.model;

/**
 * Created with IntelliJ IDEA.
 * User: vdheer
 * Date: 9/6/16
 * Time: 9:43 AM
 * To change this template use File | Settings | File Templates.
 */
public class WeekendDealsCatalog implements SupermarketCatalog {
    @Override
    public Receipt checkOut(ShoppingCart theCart) {
        return Receipt.calculateDiscountedBillFor(theCart);
    }
}
