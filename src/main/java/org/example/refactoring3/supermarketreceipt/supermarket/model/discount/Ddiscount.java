package org.example.refactoring3.supermarketreceipt.supermarket.model.discount;

import org.example.refactoring3.supermarketreceipt.supermarket.model.offer.Offer;
import org.example.refactoring3.supermarketreceipt.supermarket.model.Product;
import org.example.refactoring3.supermarketreceipt.supermarket.model.SupermarketCatalog;

import java.util.Map;

public class Ddiscount extends Discount{
    public Ddiscount(Product product, Map<Product, Offer> offers, Map<Product, Double> productQuantities, SupermarketCatalog catalog) {
        super(product, offers, productQuantities, catalog);

        discountAmount = setDiscountAmount();
        description = setDescription();
    }

    private String setDescription() {
        return offers.get(product).getX() + " for " + offers.get(product).getArgument();
    }

    private double setDiscountAmount() {
        double quantity = productQuantities.get(product);
        double unitPrice = catalog.getUnitPrice(product);
        int numberOfXs = (int) quantity / offers.get(product).getX();
        return - (unitPrice * quantity - (offers.get(product).getArgument() * numberOfXs + quantity % 5 * unitPrice));
    }
}
