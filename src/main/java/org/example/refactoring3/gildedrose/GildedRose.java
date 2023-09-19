package org.example.refactoring3.gildedrose;

import com.sun.tracing.dtrace.FunctionAttributes;

class GildedRose extends GildedroseFunctionImpl{
    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (isNotAgedBrieAndNotBackStage(i) && isQualityOverZero(i) && isNotSulfuras(i)) {
                    items[i].quality = items[i].quality - 1;
            } else {
                if (isQualityUnderFifty(i)) {
                    items[i].quality = items[i].quality + 1;
                    if (isTAFKAL80ETC(i) && isSellinUnderEleven(i) && isQualityUnderFifty(i)) {
                        items[i].quality = items[i].quality + 1;
                        if (isSellinUnderSix(i) && isQualityUnderFifty(i)) {
                            items[i].quality = items[i].quality + 1;
                        }
                    }
                }
            }
            if (isNotSulfuras(i)) items[i].sellIn = items[i].sellIn - 1;
            if (isSellinUnderZero(i)) items[i].quality = isNotAgedBrie(i) ?
                    getQualityValueBy80ZeroSulfuras(i) : getQualityValueByUnderFifty(i);
        }
    }

    private boolean isSellinUnderZero(int i) {
        return items[i].sellIn < 0;
    }

    private int getQualityValueByUnderFifty(int i) {
        return isQualityUnderFifty(i) ? items[i].quality + 1 : items[i].quality;
    }

    private int getQualityValueBy80ZeroSulfuras(int i) {
        return (!isTAFKAL80ETC(i) && isQualityOverZero(i) && isNotSulfuras(i))
                ? items[i].quality - 1 : 0;
    }

    private boolean isNotAgedBrie(int i) {
        return !items[i].name.equals("Aged Brie");
    }

    private boolean isSellinUnderSix(int i) {
        return items[i].sellIn < 6;
    }

    private boolean isSellinUnderEleven(int i) {
        return items[i].sellIn < 11;
    }

    private boolean isTAFKAL80ETC(int i) {
        return items[i].name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private boolean isQualityUnderFifty(int i) {
        return items[i].quality < 50;
    }

    private boolean isNotSulfuras(int i) {
        return !items[i].name.equals("Sulfuras, Hand of Ragnaros");
    }

    private boolean isQualityOverZero(int i) {
        return items[i].quality > 0;
    }

    private boolean isNotAgedBrieAndNotBackStage(int i) {
        return isNotAgedBrie(i)
                && !isTAFKAL80ETC(i);
    }
}
