package org.example.refactoring3.supermarketreceipt.supermarket.model;

import org.example.refactoring3.supermarketreceipt.supermarket.handle.DiscountHandler;

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

    Map<Product, Double> productQuantities() {
        return Collections.unmodifiableMap(productQuantities);
    }

    public void addItemQuantity(Product product, double quantity) {
        items.add(new ProductQuantity(product, quantity));
        boolean completeAdd = productQuantities.containsKey(product) ?
                updateProductQuantities(product, quantity) :
                initProductQuantities(product, quantity);
    }

    private boolean updateProductQuantities(Product product, double quantity) {
        productQuantities.put(product, productQuantities.get(product) + quantity);
        return true;
    }

    private boolean initProductQuantities(Product product, double quantity) {
        productQuantities.put(product, quantity);
        return true;
    }

    void handleOffers(Receipt receipt, Map<Product, Offer> offers, SupermarketCatalog catalog) {
        productQuantities().keySet().stream()
                .filter(offers::containsKey)
                .map(p->createDiscount(p, offers,catalog))
                .filter(this::isNullOfDiscount)
                .forEach(receipt::addDiscount);
    }

    private boolean isNullOfDiscount(Discount d) {
        return Optional.ofNullable(d).isPresent();
    }

    private Discount createDiscount(Product p, Map<Product, Offer> offers, SupermarketCatalog catalog) {
        return new DiscountHandler(p, offers.get(p), productQuantities.get(p), catalog)
                .createDiscount();
    }
}
