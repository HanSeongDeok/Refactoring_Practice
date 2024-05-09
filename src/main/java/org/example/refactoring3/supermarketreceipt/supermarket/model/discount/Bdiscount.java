package org.example.refactoring3.supermarketreceipt.supermarket.model.discount;

import org.example.refactoring3.supermarketreceipt.supermarket.model.Offer;
import org.example.refactoring3.supermarketreceipt.supermarket.model.Product;
import org.example.refactoring3.supermarketreceipt.supermarket.model.SpecialOfferType;
import org.example.refactoring3.supermarketreceipt.supermarket.model.SupermarketCatalog;

import java.util.Map;

public class Bdiscount extends Discount{
    public Bdiscount(Product product, Map<Product, Offer> offers, Map<Product, Double> productQuantities, SupermarketCatalog catalog) {
        super(product, offers, productQuantities, catalog);

        description = setDescription();
        discountAmount = setDiscountAmount();
    }

    public String setDescription() {
        return  "3 for 2";
    }

    public double setDiscountAmount() {
        double quantity = productQuantities.get(product);
        double unitPrice = catalog.getUnitPrice(product);
        int numberOfXs = (int) quantity / offers.get(product).getX();
        return quantity * unitPrice - ((numberOfXs * 2 * unitPrice) + quantity % 3 * unitPrice);
    }
}
