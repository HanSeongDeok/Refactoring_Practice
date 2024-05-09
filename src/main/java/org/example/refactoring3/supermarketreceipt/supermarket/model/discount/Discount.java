package org.example.refactoring3.supermarketreceipt.supermarket.model.discount;

import org.example.refactoring3.supermarketreceipt.supermarket.model.Offer;
import org.example.refactoring3.supermarketreceipt.supermarket.model.Product;
import org.example.refactoring3.supermarketreceipt.supermarket.model.SpecialOfferType;
import org.example.refactoring3.supermarketreceipt.supermarket.model.SupermarketCatalog;

import java.util.Map;

public abstract class Discount {

    String description;
    double discountAmount;
    final Product product;
    Map<Product, Offer> offers;
    Map<Product, Double> productQuantities;
    SupermarketCatalog catalog;

    public Discount(Product product, String description, double discountAmount) {
        this.product = product;
        this.description = description;
        this.discountAmount = discountAmount;
    }
    public Discount(Product product,
                              Map<Product, Offer> offers,
                              Map<Product, Double> productQuantities,
                              SupermarketCatalog catalog){
        this.product = product;
        this.offers = offers;
        this.productQuantities = productQuantities;
        this.catalog = catalog;
    }

    abstract String setDescription();
    abstract double setDiscountAmount();

    public String getDescription() {
        return description;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public Product getProduct() {
        return product;
    }
}
