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

    private static final HashMap<DealsCategory, SupermarketCatalog> DEALS_CATALOG = new HashMap();

    {
        DEALS_CATALOG.put(WeekdayDeals, new WeekdayDealsCatalog());
        DEALS_CATALOG.put(WeekendDeals, new WeekendDealsCatalog());
    }

    public Receipt checksOutArticlesFrom(ShoppingCart theCart) {

        catalog = DEALS_CATALOG.get(getTodaysDeal(currentDay));

        return catalog.checkOut(theCart);
    }

    private DealsCategory getTodaysDeal(LocalDate currentDay) {
        return (currentDay.getDayOfWeek() != FRIDAY || currentDay.getDayOfWeek() != SATURDAY || currentDay.getDayOfWeek() != SUNDAY) ? WeekdayDeals : WeekendDeals;
    }
}
