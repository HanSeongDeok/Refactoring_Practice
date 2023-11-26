package org.example.refactoring3.gildedrose2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class GildedRose {
    // 추후 해당 배열에 존재 하는 이름을 객체로 추출하면 된다.
    // (각 특수 아이템, 각 노멀 아이템, 각 특수 아이템에 포함된 전설 아이템)
    String[] specialItemNames = {"Aged Brie", "Backstage passes to a TAFKAL80ETC concert", "Sulfuras, Hand of Ragnaros"};
    String[] legendItemNames = {"Sulfuras, Hand of Ragnaros"};
    Set<String> specialItemNameSet = new HashSet<>();
    Set<String> legendItemNameSet = new HashSet<>();
    Item[] items;
    public GildedRose(Item[] items) {
        this.items = items;
        specialItemNameSet.addAll(Arrays.asList(specialItemNames));
        legendItemNameSet.addAll(Arrays.asList(legendItemNames));
    }
    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];

            // 아이템을에 대한 비교 로직들을 모아두는 레코드로 빼낸다.
            boolean isNameAgedBrie = item.name.equals("Aged Brie");
            boolean isNameBackstagePasses = item.name.equals("Backstage passes to a TAFKAL80ETC concert");
            boolean isQualityNaturalNumber = item.quality > 0;
            boolean isSellInNegativeNumber = item.sellIn < 0;
            boolean isQualityUnder50 = item.quality < 50;
            boolean isNormalItem = checkNormalItem(item);
            boolean isLegendItem = checkLegendItem(item);

            // 전설 아이템이면 아무 행위도 하지 않는다. (전설이니까)
            if (isLegendItem) continue;

            // 노멀 아이템이고 퀄리티가 자연수라면 퀄리티를 감소하는데 판매기간이 음수라면 -2, 그렇지 않다면 -1 감소시킨다.
            if (isNormalItem && isQualityNaturalNumber) item.quality = isSellInNegativeNumber ? item.quality-2 : item.quality-1;

            // 특수 아이템이고 퀄리티의 최대 값인 50 이하라면 퀄리티를 1씩 증가시킨다.
            if (!isNormalItem && isQualityUnder50) item.quality++;

            // 특수 아이템 중 백스테이지이면서
            // 판매일이 음수가 아니고 퀄리티가 50 이하일 때 판매일이 10 이하면 퀄리티 1를 추가 증가, 5이하면 2를 추가 증가 시킨다.
            if (isNameBackstagePasses && isQualityUnder50 && !isSellInNegativeNumber) {
                // 함수형으로 만들기
                if (item.sellIn < 11) item.quality++;
                if (item.sellIn < 6) item.quality++;
                // 판매일이 음수인 경우 즉, 콘서트 종료 시에는 무조건 0으로 떨어진다.
            } else if (isNameBackstagePasses && isQualityUnder50) item.quality = 0;

            // 특수 아이템 중 오래된 브리치즈이면서
            // 판매일이 음수이면서 퀄리티가 50이하일 때 추가로 퀄리티가 1씩 더 증가한다.
            if (isNameAgedBrie && isQualityUnder50 && isSellInNegativeNumber) item.quality++;

            // 전설 아이템을 제외한 모든 아이템의 판매일을 1씩 감소시킨다.
            item.sellIn--;
        }
    }
    private boolean checkLegendItem(Item item) {
        return legendItemNameSet.contains(item.name);
    }
    private boolean checkNormalItem(Item item) {
        return !specialItemNameSet.contains(item.name);
    }
}
