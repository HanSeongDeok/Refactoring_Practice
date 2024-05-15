package org.example.refactoring3.supermarketreceipt.supermarket.model.discount;

import org.example.refactoring3.supermarketreceipt.supermarket.model.offer.Offer;
import org.example.refactoring3.supermarketreceipt.supermarket.model.Product;
import org.example.refactoring3.supermarketreceipt.supermarket.model.SupermarketCatalog;

import java.util.Map;

public class Adiscount extends Discount{
    public Adiscount(Product product, Map<Product, Offer> offers, Map<Product, Double> productQuantities, SupermarketCatalog catalog) {
        super(product, offers, productQuantities, catalog);

        discountAmount = setDiscountAmount();
        description = setDescription();
    }

    private double setDiscountAmount() {
        double quantity = productQuantities.get(product);
        double unitPrice = catalog.getUnitPrice(product);
        double total = offers.get(product).getArgument() * (quantity / offers.get(product).getX()) + quantity % 2 * unitPrice;
        double discountN = catalog.getUnitPrice(product) * quantity - total;
        return -discountN;
    }

    private String setDescription() {
        return  "2 for " + offers.get(product).getArgument();
    }
}
