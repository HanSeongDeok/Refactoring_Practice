package org.example.refactoring3.supermarketreceipt.supermarket.model.discount;

import org.example.refactoring3.supermarketreceipt.supermarket.model.Offer;
import org.example.refactoring3.supermarketreceipt.supermarket.model.Product;
import org.example.refactoring3.supermarketreceipt.supermarket.model.SupermarketCatalog;

import java.util.Map;

public class Adiscount extends Discount{
    public Adiscount() {}

    public void setDiscountInfo(DiscountInfo info){
        product = info.product();
        offers = info.offers();
        productQuantities = info.productQuantities();
        catalog = info.catalog();
        discountAmount = setDiscountAmount();
        description = setDescription();
    }

    private double setDiscountAmount() {
        double quantity = productQuantities.get(product);
        double unitPrice = catalog.getUnitPrice(product);
        double total = offers.get(product).getArgument() * (quantity / offers.get(product).getX()) + quantity % 2 * unitPrice;
        double discountN = catalog.getUnitPrice(product) * quantity - total;
        return -discountN;
    }

    private String setDescription() {
        return  "2 for " + offers.get(product).getArgument();
    }
}
