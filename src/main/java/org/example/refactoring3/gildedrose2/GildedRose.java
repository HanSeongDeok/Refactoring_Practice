package org.example.refactoring3.gildedrose2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class GildedRose {
    Item[] items;
    public GildedRose(Item[] items) {
        this.items = items;
    }
    // TODO TEST 코드 작성
    public void updateQuality() {
        Arrays.stream(items)
                .map(ItemFunc::stream)
                .filter(ItemFunc::isLegendItem)
                .forEach(itemFunc -> itemFunc
                        .processQualityEachItem()
                        .processSellIn()
                        .done());
    }
}
