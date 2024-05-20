package org.example.refactoring3.supermarketreceipt.supermarket.model.discount;

import org.example.refactoring3.supermarketreceipt.supermarket.model.Offer;
import org.example.refactoring3.supermarketreceipt.supermarket.model.Product;
import org.example.refactoring3.supermarketreceipt.supermarket.model.SupermarketCatalog;

import java.util.Map;

public class Discount {
    String description;
    double discountAmount;
    Product product;
    Map<Product, Offer> offers;
    Map<Product, Double> productQuantities;
    SupermarketCatalog catalog;

    public Discount(Product product, String description, double discountAmount) {
        this.product = product;
        this.description = description;
        this.discountAmount = discountAmount;
    }
    public Discount(){}

    public String getDescription() {
        return description;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public Product getProduct() {
        return product;
    }

    public void setDiscountInfo(DiscountInfo info){
        product = info.product();
        offers = info.offers();
        productQuantities = info.productQuantities();
        catalog = info.catalog();
    }
}
