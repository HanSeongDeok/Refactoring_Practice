package org.example.refactoring3.supermarketreceipt.supermarket.model.offer;
import org.example.refactoring3.supermarketreceipt.supermarket.model.Product;
import java.util.Optional;

public class Offer {
    SpecialOfferType offerType;
    private final Product product;
    double argument;

    public Offer(SpecialOfferType offerType, Product product, double argument) {
        this.offerType = offerType;
        this.argument = argument;
        this.product = product;
    }

    Product getProduct() {
        return product;
    }

    public SpecialOfferType getOfferType() {
        return offerType;
    }

    public double getArgument(){
        return argument;
    }

    public int getX(){
        Optional.ofNullable(offerType).orElseThrow(NullPointerException::new);
        return offerType.getX();
    }
}
