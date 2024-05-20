package org.example.refactoring3.supermarketreceipt.supermarket.model.discount;

import org.example.refactoring3.supermarketreceipt.supermarket.model.Offer;
import org.example.refactoring3.supermarketreceipt.supermarket.model.Product;
import org.example.refactoring3.supermarketreceipt.supermarket.model.SupermarketCatalog;

import java.util.Map;

public class DiscountFactory {
    DiscountInfo discountInfo;

    public DiscountFactory(DiscountInfo discountInfo) {
        this.discountInfo = discountInfo;
    }
    public Discount factory() {
        return discountInfo.offers().get(discountInfo.product())
                .getOfferType()
                .getDiscount(discountInfo);
    }
}
