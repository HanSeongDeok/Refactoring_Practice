package org.example.refactoring3.supermarketreceipt.supermarket.model.discount;

import org.example.refactoring3.supermarketreceipt.supermarket.model.Offer;
import org.example.refactoring3.supermarketreceipt.supermarket.model.Product;
import org.example.refactoring3.supermarketreceipt.supermarket.model.SupermarketCatalog;

import java.util.Map;

public class Bdiscount extends Discount{
    public Bdiscount() {}

    public void setDiscountInfo(DiscountInfo info){
        product = info.product();
        offers = info.offers();
        productQuantities = info.productQuantities();
        catalog = info.catalog();
        discountAmount = setDiscountAmount();
        description = setDescription();
    }

    private String setDescription() {
        return  "3 for 2";
    }

    private double setDiscountAmount() {
        double quantity = productQuantities.get(product);
        double unitPrice = catalog.getUnitPrice(product);
        int numberOfXs = (int) quantity / offers.get(product).getX();
        return quantity * unitPrice - ((numberOfXs * 2 * unitPrice) + quantity % 3 * unitPrice);
    }
}
