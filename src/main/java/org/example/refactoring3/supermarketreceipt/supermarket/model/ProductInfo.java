package org.example.refactoring3.supermarketreceipt.supermarket.model;

import java.util.List;
import java.util.Map;

public record ProductInfo(
        Product product,
        double quantity,
        List<ProductQuantity> items,
        Map<Product, Double> productQuantities) {
}
