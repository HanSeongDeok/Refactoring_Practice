package org.example.patternpractice.observer;

public class Client {
    public static void main(String[] args) {
        Stock stock1 = new Stock("oneStock");
        Stock stock2 = new Stock("twoStock");
        Stock stock3 = new Stock("threeStock");

        StockMarket market = new StockMarket();
        market.storeStock(stock1);
        market.storeStock(stock2);
        market.storeStock(stock3);

        market.updateStockCommonValue(10L);
        System.out.println();
        market.updateStockCommonValue(20L);
        System.out.println();
        market.updateStockCommonValue(30L);
        System.out.println();
    }
}
