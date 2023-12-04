package org.example.refactoring3.gildedrose2;

import org.example.refactoring3.gildedrose2.item.ItemFactory;
import org.example.refactoring3.gildedrose2.item.LegendItem;

public class ItemFunc {
    private final Item item;
    private final ItemRecord record;
    private final ItemFactory factory;
    private ItemFunc(Item item){
        this.item = item;
        this.record = new ItemRecord(item);
        this.factory = ItemFactory.factory(item);
    }
    public static ItemFunc stream(Item item){
        return new ItemFunc(item);
    }
    public boolean isNotLegendItem(){
        return !item.name.equals(LegendItem.SULFURAS);
    }

    /**
     * 아이템 타입 별 자동으로 퀄리티 연산처리를 계산한다.
     * @return ItemFunc
     */
    public ItemFunc calQuality(){
        // 아이템 타입 별로 퀄리티를 계산한다
       item.quality = factory.calQuality();
       return this;
    }

    /**
     * 전설아이템을 제외한 모든 아이템의 판매일을 1씩 감소시킨다.
     * @return ItemFunc
     */
    public ItemFunc calSellIn(){
        // 전설 아이템을 제외한 모든 아이템의 판매일을 1씩 감소시킨다.
        item.sellIn = factory.calSellIn();
        return this;
    }

    public void done(){
        //Do Nothing
    }
}
