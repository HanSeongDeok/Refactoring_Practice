package org.example.refactoring3.supermarketreceipt.supermarket.model.discount;

import org.example.refactoring3.supermarketreceipt.supermarket.model.Offer;
import org.example.refactoring3.supermarketreceipt.supermarket.model.Product;
import org.example.refactoring3.supermarketreceipt.supermarket.model.SupermarketCatalog;

import java.util.Map;

public class DiscountFactory {
    DiscountInfo discountInfo;
    Product p;

    public DiscountFactory(Product p, DiscountInfo discountInfo) {
        this.discountInfo = discountInfo;
        this.p = p;
    }
    public Discount factory() {
        return discountInfo.offers().get(p)
                .getOfferType()
                .getDiscount(discountInfo);
    }
}
