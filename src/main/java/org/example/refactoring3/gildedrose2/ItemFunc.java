package org.example.refactoring3.gildedrose2;

public class ItemFunc {
    private final Item item;
    private final ItemComparisonRecord comparisonRecord;
    private ItemFunc(Item item){
        this.item = item;
        this.comparisonRecord = new ItemComparisonRecord(item);
    }
    public static ItemFunc stream(Item item){
        return new ItemFunc(item);
    }

    public boolean isLegendItem(){
        return comparisonRecord.isLegendItem();
    }

    /**
     * 아이템 타입 별 자동으로 퀄리티 연산처리를 계산한다.
     * @return ItemFunc
     */
    public ItemFunc processQualityEachItem(){
        // 노멀 아이템이고 퀄리티가 자연수라면 퀄리티를 감소하는데 판매기간이 음수라면 -2, 그렇지 않다면 -1 감소시킨다.
        if (comparisonRecord.isNormalAndPositiveQuality()) {
            item.quality = calculateQualityBySellIn(-2, -1); return this;
        }

        // TODO 추가된 변경 사항
        // 짱 나쁜 아이템이고 퀄리티가 자연수라면 퀄리티를 감소하는데 판매기간이 음수라면 -4, 그렇지 않다면 -2 감소시킨다.
        if (comparisonRecord.isSoBadAndPositiveQuality()) {
            item.quality = calculateQualityBySellIn(-4, -2); return this;
        }

        // 특수 아이템이고 퀄리티의 최대 값인 50 이하라면 퀄리티를 1씩 증가시킨다.
        if (comparisonRecord.isSpecialAndQualityUnder50()) item.quality = calculateQualityBySpecialFeature();
        return this;
    }

    // 특수 아이템 퀄리티 계산 처리
    private int calculateQualityBySpecialFeature(){
        // 특수 아이템이고 퀄리티의 최대 값인 50 이하라면 퀄리티를 1씩 증가시킨다.
        item.quality++;

        // 특수 아이템 중 백스테이지이면서 판매일이 음수가 아니고 퀄리티가 50 이하일 때 판매일이
        if (comparisonRecord.isBackStageProcess()) {
            if (item.sellIn < 11) item.quality++; // 10 이하면 퀄리티 1를 추가 증가
            if (item.sellIn < 6) item.quality++; //  5이하면 2를 추가 증가
            return item.quality;
        }

        // 특수 아이템 중 백스테이지이면서 판매일이 음수인 경우 즉, 콘서트 종료 시에는 무조건 0으로 떨어진다.
        if (comparisonRecord.isBackStageProcessInCaseNegativeSellIn()) {
            item.quality = 0; return item.quality;
        }

        // 특수 아이템 중 오래된 브리치즈이면서 판매일이 음수이면서 퀄리티가 50이하일 때 추가로 퀄리티가 1씩 추가 증가한다.
        if (comparisonRecord.isAgedBrieProcess()) {
            item.quality++; return item.quality;
        }
        return item.quality;
    }

    // 노멀 아이템 혹은 감염된 아이템의 퀄리티 계산 처리
    private int calculateQualityBySellIn(int x, int y) {
        return comparisonRecord.isSellInNegativeNumber() ?
                item.quality + x :  // 음수라면 -x
                item.quality + y;   // 그렇지 않다면 -y 감소시킨다.
    }

    /**
     * 전설아이템을 제외한 모든 아이템의 판매일을 1씩 감소시킨다.
     * @return ItemFunc
     */
    public ItemFunc processSellIn(){
        // 전설 아이템을 제외한 모든 아이템의 판매일을 1씩 감소시킨다.
        item.sellIn--;
        return this;
    }

    // 끝을 명시적으로 알림. valid 처리 넣는 부분
    public void done(){
        //TODO Validation Logic
    }
}
