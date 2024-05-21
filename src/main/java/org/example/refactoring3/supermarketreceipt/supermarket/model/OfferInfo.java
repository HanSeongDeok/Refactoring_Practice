package org.example.refactoring3.supermarketreceipt.supermarket.model;

import org.example.refactoring3.supermarketreceipt.supermarket.model.discount.DiscountFactory;
import org.example.refactoring3.supermarketreceipt.supermarket.model.discount.DiscountInfo;

public record OfferInfo(
        Receipt receipt,
        DiscountInfo discountInfo) {
        private static OfferInfoBuilder builder;

        public static OfferInfoBuilder getInstance(){
            return builder == null ? builder = new OfferInfoBuilder() : builder;
        }

        static class OfferInfoBuilder{
            Receipt receipt;
            DiscountInfo discountInfo;

            public OfferInfoBuilder setReceipt(Receipt receipt) {
                this.receipt = receipt;
                return this;
            }

            public OfferInfoBuilder setDiscountInfo(DiscountInfo discountInfo) {
                this.discountInfo = discountInfo;
                return this;
            }

            public OfferInfo build(){
                return new OfferInfo(receipt, discountInfo);
            }
        }
}
