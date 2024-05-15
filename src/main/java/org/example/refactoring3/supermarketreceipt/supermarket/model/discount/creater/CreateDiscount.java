package org.example.refactoring3.supermarketreceipt.supermarket.model.discount.creater;
import org.example.refactoring3.supermarketreceipt.supermarket.model.Product;
import org.example.refactoring3.supermarketreceipt.supermarket.model.SupermarketCatalog;
import org.example.refactoring3.supermarketreceipt.supermarket.model.discount.Discount;
import org.example.refactoring3.supermarketreceipt.supermarket.model.offer.Offer;

import java.util.Map;

public interface CreateDiscount<T extends Discount> {
    CreateDiscount<?> setConditionInfo(Map<Product, Double> productQuantities,
                          SupermarketCatalog catalog,
                          Product product,
                          Map<Product, Offer> offers);
    T create();
}
