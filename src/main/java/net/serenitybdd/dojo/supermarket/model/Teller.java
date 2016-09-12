package net.serenitybdd.dojo.supermarket.model;

import java.time.LocalDate;
import java.util.HashMap;

import static java.time.DayOfWeek.*;
import static net.serenitybdd.dojo.supermarket.model.DealsCategory.*;

public class Teller {

    private final LocalDate currentDay = LocalDate.now();

    private SupermarketCatalog catalog;

    public Teller(SupermarketCatalog catalog) {

        this.catalog = catalog;
    }

    public Receipt checksOutArticlesFrom(ShoppingCart theCart) {

        //catalog = DEALS_CATALOG.get(getTodaysDeal(currentDay));

        return this.catalog.checkOut(theCart);
    }
}
