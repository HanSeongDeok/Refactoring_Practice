package org.example.patternpractice.observer;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class Stock implements Observer {
    Map<Long, Long> valueMap = new HashMap<>();
    AtomicLong value = new AtomicLong();
    String stockName;
    public Stock(String stockName) {
        this.stockName = stockName;
    }
    public void update(long value) {
        valueMap.put(this.value.getAndIncrement(), value);
        System.out.println(stockName +
                (this.value.get()-1) +
                ": " +"update complete " +
                value);
    }
}
