package org.example.refactoring3.supermarketreceipt.supermarket.handle;

import org.example.refactoring3.supermarketreceipt.supermarket.model.Product;
import org.example.refactoring3.supermarketreceipt.supermarket.model.ProductInfo;
import org.example.refactoring3.supermarketreceipt.supermarket.model.ProductQuantity;

import java.util.List;
import java.util.Map;

public class ProductHandler {
    private final ProductInfo productInfo;
    private final Map<Product, Double> productQuantities;

    public ProductHandler(ProductInfo productInfo) {
        this.productInfo = productInfo;
        this.productQuantities = productInfo.productQuantities();
    }

    public void addItem(){
        // items update
        productInfo.items().add(new ProductQuantity(productInfo.product(), productInfo.quantity()));

        // product update
        if(productInfo.productQuantities().containsKey(productInfo.product())) {
            updateProductQuantities(productInfo.product(), productInfo.quantity());
        } else {
            initProductQuantities(productInfo.product(), productInfo.quantity());
        }

    }

    private void updateProductQuantities(Product product, double quantity) {
        productQuantities.put(product, productQuantities.get(product) + quantity);
    }

    private void initProductQuantities(Product product, double quantity) {
        productQuantities.put(product, quantity);
    }
}
