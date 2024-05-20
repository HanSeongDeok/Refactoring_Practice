package org.example.refactoring3.supermarketreceipt.supermarket.model.discount;

import org.example.refactoring3.supermarketreceipt.supermarket.model.Offer;
import org.example.refactoring3.supermarketreceipt.supermarket.model.Product;
import org.example.refactoring3.supermarketreceipt.supermarket.model.SupermarketCatalog;

import java.util.Map;

public class Cdiscount extends Discount{
    public Cdiscount() {}

    public void setDiscountInfo(DiscountInfo info){
        product = info.product();
        offers = info.offers();
        productQuantities = info.productQuantities();
        catalog = info.catalog();
        discountAmount = setDiscountAmount();
        description = setDescription();
    }

    private double setDiscountAmount() {
        return -productQuantities.get(product) * catalog.getUnitPrice(product) * offers.get(product).getArgument() / 100.0;
    }

    private String setDescription() {
        return offers.get(product).getArgument() + "% off";
    }
}
