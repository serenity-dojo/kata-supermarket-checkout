package net.serenitybdd.dojo.supermarket.model;

/**
 * Created with IntelliJ IDEA.
 * User: vdheer
 * Date: 9/6/16
 * Time: 9:56 AM
 * To change this template use File | Settings | File Templates.
 */
public enum Products {
    NoProduct(0.00), Rice(2.00), Apples(3.00), Milk(1.00), Toothbrush(0.50), Chocolates(1.00), Oranges(5.00);

    private double price;

    private Products(double price) {
        this.price = price;
    }

    public double getPrice(){
        return price;
    }
}
