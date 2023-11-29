package org.example.refactoring3.gildedrose2;

public class ItemFunc {
    private final Item item;
    private final ItemRecord record;
    private ItemFunc(Item item){
        this.item = item;
        this.record = new ItemRecord(item);
    }
    public static ItemFunc stream(Item item){
        return new ItemFunc(item);
    }
    public boolean isNotLegendItem(){
        return !record.isLegendItem();
    }

    /**
     * 아이템 타입 별 자동으로 퀄리티 연산처리를 계산한다.
     * @return ItemFunc
     */
    public ItemFunc calQuality(){
        // 노멀 아이템
        if (record.isNormalQCal()) item.quality = calQBySellIn(-2, -1);

        // TODO 추가된 변경 사항
        // 짱 나쁜 아이템
        if (record.isSoBadQCal()) item.quality = calQBySellIn(-4, -2);

        // 특수 아이템
        if (record.isSpecialQCal()) item.quality = calQBySpecial();
        return this;
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

    // 노멀 아이템, 감염된 아이템 퀄리티 계산
    private int calQBySellIn(int x, int y) {
        return (item.sellIn < -1) ?
                    item.quality + x :  // 판매일이 음수라면 -x
                    item.quality + y;   // 그렇지 않다면 -y 감소시킨다.
    }

    /**
     * 전설아이템을 제외한 모든 아이템의 판매일을 1씩 감소시킨다.
     * @return ItemFunc
     */
    public ItemFunc calSellIn(){
        // 전설 아이템을 제외한 모든 아이템의 판매일을 1씩 감소시킨다.
        item.sellIn--;
        return this;
    }

    /**
     * 끝.
     */
    public void done(){
        //Do Nothing
    }

    public static void main(String[] args) {
        Item item = new Item("foo", 1, 0);

        System.out.println("sellIn : " + item.sellIn);
        System.out.println(ItemFunc.stream(item).record.isMinorSellIn());

        item.sellIn = -1;
        System.out.println("sellIn : " + item.sellIn);
        System.out.println(ItemFunc.stream(item).record.isMinorSellIn());
    }
}
