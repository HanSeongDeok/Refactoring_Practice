package org.example.refactoring3.gildedrose2.item;

import org.example.refactoring3.gildedrose2.Item;
import org.example.refactoring3.gildedrose2.ItemRecord;

public class SpecialItem extends ItemFactory{
    public static final String AGED_BRIE = ItemRecord.AGED_BRIE;
    public static final String BACK_STAGE = ItemRecord.BACK_STAGE;
    public SpecialItem(Item item) {
        super(item);
    }
    @Override
    public int calQuality() {
        return item.quality < 50 ?
                calQBySpecial() :
                50;
    }
    @Override
    public int calSellIn() {
        return 0;
    }

    // 특수 아이템 퀄리티 계산 처리
    private int calQBySpecial(){
        item.quality++;

        // 백스테이지 남은 판매일 별 퀄리티 계산.
        if (record.isBackStageQCalPlus()) {
            if (item.sellIn < 11) item.quality++; // 10 이하 퀄리티 1 추가 증가
            if (item.sellIn < 6) item.quality++; //  5이하 2 추가 증가
        }

        // 백스테이지콘서트 종료 시 0.
        if (record.isBackStageQCalZero()) item.quality = 0;

        // 오래된 브리치즈, 판매일이 음수, 퀄리티가 50이하 -> 퀄리티 1 추가 증가.
        if (record.isAgedBrieQCal()) item.quality++;

        return item.quality;
    }
}
