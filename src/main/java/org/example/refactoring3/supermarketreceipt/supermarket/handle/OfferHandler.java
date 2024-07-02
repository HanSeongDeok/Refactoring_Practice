package org.example.refactoring3.supermarketreceipt.supermarket.handle;

import org.example.refactoring3.supermarketreceipt.supermarket.model.OfferInfo;
import org.example.refactoring3.supermarketreceipt.supermarket.model.Product;

import java.util.Map;

public class OfferHandler {
    private final OfferInfo offerInfo;
    private final Map<Product, Double> productDoubleMap;
    private final DiscountHandler handler;

    public OfferHandler(OfferInfo offerInfo){
        this.offerInfo = offerInfo;
        this.productDoubleMap = offerInfo.discountInfo().productQuantities();
        this.handler = new DiscountHandler(offerInfo.discountInfo());
    }

    public void addDiscountInReceipt(){
        productDoubleMap.keySet().stream()
                    .filter(offerInfo.discountInfo().offers()::containsKey)
                    .map(handler::createDiscount)
                    .filter(DiscountHandler::isNullOfDiscount)
                    .forEach(offerInfo.receipt()::addDiscount);
    }
}
