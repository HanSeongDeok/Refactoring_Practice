package org.example.refactoring3.gildedrose2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public record ItemRecord(Item item) {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACK_STAGE = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String CONJURED="Conjured";
    private static final String[] specialItemNames, legendItemNames, soBadItemNames;
    private static final Set<String> specialItemNameSet, legendItemNameSet, soBadItemNameSet; // 특수 아이템  // 전설 아이템
    // 추후 해당 배열에 존재 하는 이름을 객체로 추출하면 된다. (각 특수 아이템, 각 노멀 아이템, 각 특수 아이템에 포함된 전설 아이템)
    static{
        // array
        specialItemNames = new String[]{AGED_BRIE, BACK_STAGE, SULFURAS};
        legendItemNames = new String[]{SULFURAS};
        soBadItemNames = new String[]{CONJURED};
        // set
        specialItemNameSet = new HashSet<>(Arrays.asList(specialItemNames));
        legendItemNameSet = new HashSet<>(Arrays.asList(legendItemNames));
        soBadItemNameSet = new HashSet<>(Arrays.asList(soBadItemNames));
    }
    public boolean isSoBadItem() {
        return item != null && soBadItemNameSet.contains(item.name);
    }
    public boolean isLegendItem() {
        return item != null && legendItemNameSet.contains(item.name);
    }
    public boolean isNormalItem() {
        return item != null && !specialItemNameSet.contains(item.name);
    }
    public boolean isSpecialItem(){
        return item != null && specialItemNameSet.contains(item.name);
    }

    public boolean isMinorSellIn(){
        return item != null && item.sellIn < 0;
    }

    /**
     * <h2><li>짱 나쁜 아이템이고 퀄리티가 자연수라면 퀄리티를 감소하는데 판매기간이 음수라면 -4, 그렇지 않다면 -2 감소시킨다.</li></h2>
     * @return soBadItemNameSet.contains(item.name) && item.quality > 0
     */
    public boolean isSoBadQCal() {
        return item != null && isSoBadItem() && item.quality > 0;
    }

    /**
     * <h2><li>노멀 아이템이고 퀄리티가 자연수라면 퀄리티를 감소하는데 판매기간이 음수라면 -2, 그렇지 않다면 -1 감소시킨다.</li></h2>
     * @return !specialItemNameSet.contains(item.name) && item.quality > 0
     */
    public boolean isNormalQCal() {
        return item != null && isNormalItem() && item.quality > 0;
    }

    /**
     * <h2><li> 특수 아이템이고 퀄리티의 최대 값인 50 이하라면 퀄리티를 1씩 증가시킨다. </li></h2>
     * @return isSpecialItem && isQualityUnder50
     */
    public boolean isSpecialQCal(){
        return item != null && isSpecialItem() && item.quality < 50;
    }

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
