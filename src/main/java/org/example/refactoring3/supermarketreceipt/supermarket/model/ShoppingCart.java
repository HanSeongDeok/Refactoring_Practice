package org.example.refactoring3.supermarketreceipt.supermarket.model;

import org.example.refactoring3.supermarketreceipt.supermarket.handle.DiscountHandler;
import org.example.refactoring3.supermarketreceipt.supermarket.handle.ProductHandler;
import org.example.refactoring3.supermarketreceipt.supermarket.model.offer.Offer;

import java.util.*;

public class ShoppingCart {

    private final List<ProductQuantity> items = new ArrayList<>();
    private final Map<Product, Double> productQuantities = new HashMap<>();

    List<ProductQuantity> getItems() {
        return Collections.unmodifiableList(items);
    }

    void addItem(Product product) {
        addItemQuantity(product, 1.0);
    }

    Map<Product, Double> getProductQuantities() {
        return Collections.unmodifiableMap(productQuantities);
    }

    public void addItemQuantity(Product product, double quantity) {
        new ProductHandler(product, quantity, getItems(), getProductQuantities())
                .setShoppingCart();
        }
        
    void handleOffers(Receipt receipt, Map<Product, Offer> offers, SupermarketCatalog catalog) {
        DiscountHandler handler = new DiscountHandler(offers, productQuantities, catalog);
        getProductQuantities().keySet().stream()
                .filter(offers::containsKey)
                .map(handler::createDiscount)
                .filter(DiscountHandler::isNullOfDiscount)
                .forEach(receipt::addDiscount);
    }
}
