package org.example.refactoring3.supermarketreceipt.supermarket.model;

import org.example.refactoring3.supermarketreceipt.supermarket.handle.DiscountHandler;
import org.example.refactoring3.supermarketreceipt.supermarket.handle.OfferHandler;
import org.example.refactoring3.supermarketreceipt.supermarket.handle.ProductHandler;
import org.example.refactoring3.supermarketreceipt.supermarket.model.discount.DiscountInfo;

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
        new ProductHandler(new ProductInfo(product, quantity, items, productQuantities))
                .addItem();
        }
        
    void handleOffers(Receipt receipt, Map<Product, Offer> offers, SupermarketCatalog catalog) {
        // 방법 1
        /*OfferHandler offerHandler = new OfferHandler(new OfferInfo(receipt, new DiscountInfo(offers, productQuantities, catalog)));
        offerHandler.addDiscountInReceipt();*/

        // 방법 2
        new OfferHandler(OfferInfo.getInstance()
                .setReceipt(receipt)
                .setDiscountInfo(new DiscountInfo(offers, productQuantities, catalog))
                .build())
                .addDiscountInReceipt();
    }
}
