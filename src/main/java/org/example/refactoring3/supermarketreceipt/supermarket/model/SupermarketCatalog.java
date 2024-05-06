package org.example.refactoring3.supermarketreceipt.supermarket.model;

public interface SupermarketCatalog {

    void addProduct(Product product, double price);

    double getUnitPrice(Product product);
}
