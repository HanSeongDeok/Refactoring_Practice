package org.example.refactoring3.supermarketreceipt.supermarket.handle;

import org.example.refactoring3.supermarketreceipt.supermarket.model.*;
import org.example.refactoring3.supermarketreceipt.supermarket.model.discount.Discount;
import org.example.refactoring3.supermarketreceipt.supermarket.model.discount.DiscountFactory;
import org.example.refactoring3.supermarketreceipt.supermarket.model.discount.DiscountInfo;
import java.util.Optional;

public class DiscountHandler {
    private final DiscountInfo discountInfo;
    public DiscountHandler(DiscountInfo discountInfo){
        this.discountInfo = discountInfo;
    }

    public Discount createDiscount(Product p) {
        return new DiscountFactory(p, discountInfo).factory();
    }

    public static boolean isNullOfDiscount(Discount d) {
        return Optional.ofNullable(d).isPresent();
    }


}
