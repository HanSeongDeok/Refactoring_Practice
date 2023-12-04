package org.example.refactoring3.gildedrose2.item;

import org.example.refactoring3.gildedrose2.Item;
import org.example.refactoring3.gildedrose2.ItemRecord;

public class ConjuredItem extends ItemFactory{
    public static final String CONJURED= ItemRecord.CONJURED;
   public ConjuredItem(Item item) {
       super(item);
   }

    @Override
    public int calSellIn() {
        return reduceSellIn();
    }

    @Override
    public int calQuality() {
       return item.quality == 0 ?
                0 :
                calQBySellIn(-4, -2);
    }
}
