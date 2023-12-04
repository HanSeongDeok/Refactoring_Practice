package org.example.refactoring3.gildedrose2.item;

import org.example.refactoring3.gildedrose2.Item;
import org.example.refactoring3.gildedrose2.ItemFunc;
import org.example.refactoring3.gildedrose2.ItemRecord;

public abstract class ItemFactory{
    protected Item item;
    protected ItemRecord record;
    protected ItemFactory(Item item){
        this.item = item;
        this.record = new ItemRecord(item);
    }
    public static ItemFactory factory(Item item){
        if (item == null) throw new NullPointerException("아이템은 Null 이 될 수 없습니다.");
        if (item.name.equals(SpecialItem.BACK_STAGE) || item.name.equals(SpecialItem.AGED_BRIE)) return new SpecialItem(item);
        if (item.name.equals(LegendItem.SULFURAS)) return new LegendItem(item);
        if (item.name.equals(ConjuredItem.CONJURED)) return new ConjuredItem(item);
        return new NormalItem(item);
    }
    abstract public int calSellIn();
    abstract public int calQuality();

    // 노멀 아이템, 감염된 아이템 퀄리티 계산
    protected int calQBySellIn(int x, int y) {
        return (item.sellIn < -1) ?
                    item.quality + x :  // 판매일이 음수라면 -x
                    item.quality + y;   // 그렇지 않다면 -y 감소시킨다.
    }

    protected int reduceSellIn(){
        // 전설 아이템을 제외한 모든 아이템의 판매일을 1씩 감소시킨다.
        return item.sellIn--;
    }
}
