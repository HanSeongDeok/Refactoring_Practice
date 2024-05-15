package org.example.refactoring3.supermarketreceipt.supermarket.model.discount;

import org.example.refactoring3.supermarketreceipt.supermarket.model.offer.Offer;
import org.example.refactoring3.supermarketreceipt.supermarket.model.Product;
import org.example.refactoring3.supermarketreceipt.supermarket.model.SupermarketCatalog;

import java.util.Map;

public class Cdiscount extends Discount{
    public Cdiscount(Product product, Map<Product, Offer> offers, Map<Product, Double> productQuantities, SupermarketCatalog catalog) {
        super(product, offers, productQuantities, catalog);
        description = setDescription();
        discountAmount = setDiscountAmount();
    }

    private double setDiscountAmount() {
        return -productQuantities.get(product) * catalog.getUnitPrice(product) * offers.get(product).getArgument() / 100.0;
    }

    private String setDescription() {
        return offers.get(product).getArgument() + "% off";
    }
}
