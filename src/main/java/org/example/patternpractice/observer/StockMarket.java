package org.example.patternpractice.observer;

import java.util.ArrayList;
import java.util.List;

public class StockMarket {
     List<Stock> list = new ArrayList<>();

     public void storeStock(Stock stock){
         list.add(stock);
     }

     public void updateStockCommonValue(long value) {
         list.forEach(stock -> stock.update(value));
     }
}
