package org.example.refactoring3.supermarketreceipt.supermarket.model.discount;

import org.example.refactoring3.supermarketreceipt.supermarket.model.Offer;
import org.example.refactoring3.supermarketreceipt.supermarket.model.Product;
import org.example.refactoring3.supermarketreceipt.supermarket.model.SupermarketCatalog;

import java.util.Map;

public record DiscountInfo(Product product,
        Map<Product, Offer>offers,
        Map<Product, Double> productQuantities,
        SupermarketCatalog catalog) {
}
