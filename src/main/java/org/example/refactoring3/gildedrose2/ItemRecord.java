package org.example.refactoring3.gildedrose2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public record ItemRecord(Item item) {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACK_STAGE = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String CONJURED= "Conjured";

    /**
     * <h2><li>특수 아이템 중 백스테이지이면서 판매일이 음수가 아니고 퀄리티가 50 이하일 때 판매일이 10 이하면 퀄리티 1를 추가 증가 5이하면 2를 추가 증가</li></h2>
     * @return item.name.equals(BACK_STAGE) && item.quality < 50 && item.sellIn >= 0
     */
    public boolean isBackStageQCalPlus(){
        return item != null && item.name.equals(BACK_STAGE) &&
                item.quality < 50 &&
                item.sellIn >= 0;
    }

    /**
     * <h2><li>판매일이 음수인 경우 즉, 콘서트 종료 시에는 무조건 0으로 떨어짐</li></h2>
     * @return item.name.equals(BACK_STAGE) && item.quality < 50 && item.sellIn < 0;
     */
    public boolean isBackStageQCalZero(){
        return item != null && item.name.equals(BACK_STAGE) &&
                item.quality < 50 &&
                item.sellIn < 0;
    }

    /**
     * <h2><li>특수 아이템 중 오래된 브리치즈이면서 판매일이 음수이면서 퀄리티가 50이하일 때 추가로 퀄리티가 1씩 추가 증가</li></h2>
     * @return item.name.equals(AGED_BRIE) && item.quality < 50 && item.sellIn < 0;
     */
    public boolean isAgedBrieQCal(){
        return item != null && item.name.equals(AGED_BRIE) &&
                item.quality < 50 &&
                item.sellIn < 0;
    }
}
