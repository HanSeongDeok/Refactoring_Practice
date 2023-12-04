package org.example.refactoring3.gildedrose2.item;

import org.example.refactoring3.gildedrose2.Item;
import org.example.refactoring3.gildedrose2.ItemRecord;

public class NormalItem extends ItemFactory{
    public NormalItem(Item item) {
        super(item);
    }
    @Override
    public int calQuality() {
        return item.quality > 0 ?
                calQBySellIn(-2, -1) :
                0;
    }
    @Override
    public int calSellIn() {
        return 0;
    }
}
