package org.example.refactoring3.supermarketreceipt.supermarket.handle;

import org.example.refactoring3.supermarketreceipt.supermarket.model.Product;
import org.example.refactoring3.supermarketreceipt.supermarket.model.ProductQuantity;

import java.util.List;
import java.util.Map;

public class ProductHandler {
    private final Product product;
    private final double quantity;
    private List<ProductQuantity> items;
    private Map<Product, Double> productQuantities;

    public ProductHandler(Product product, double quantity, List<ProductQuantity> items, Map<Product, Double> productQuantities) {
        this.product = product;
        this.quantity = quantity;
        this.items = items;
        this.productQuantities = productQuantities;
    }

    public void addItems(){
        items.add(new ProductQuantity(product, quantity));
        productQuantities = productQuantities.containsKey(product) ?
                updateProductQuantities(product, quantity) :
                initProductQuantities(product, quantity);
    }

    private Map<Product, Double> updateProductQuantities(Product product, double quantity) {
        productQuantities.put(product, productQuantities.get(product) + quantity);
        return productQuantities;
    }

    private Map<Product, Double> initProductQuantities(Product product, double quantity) {
        productQuantities.put(product, quantity);
        return productQuantities;
    }
}
