package org.example.refactoring3.gildedrose2;

class GildedRose {
    Item[] items;
    public GildedRose(Item[] items) {
        this.items = items;
    }
    // TODO TEST 코드 작성
    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];
            ItemComparisonRecord comparisonRecord = new ItemComparisonRecord(item);
            if (comparisonRecord.isLegendItem()) continue; // 전설 아이템이면 아무 행위도 하지 않는다. (전설이니까)

            // 노멀 아이템이고 퀄리티가 자연수라면 퀄리티를 감소하는데 판매기간이
            if (comparisonRecord.isNormalAndPositiveQuality()) item.quality = comparisonRecord.isSellInNegativeNumber() ?
                                                                                    item.quality-2 :  // 음수라면 -2
                                                                                    item.quality-1;   // 그렇지 않다면 -1 감소시킨다.

            // TODO 추가된 변경 사항
            // 짱 나쁜 아이템이고 퀄리티가 자연수라면 퀄리티를 감소하는데 판매기간이
            if (comparisonRecord.isSoBadAndPositiveQuality()) item.quality = comparisonRecord.isSellInNegativeNumber() ?
                                                                                    item.quality-4 :  // 음수라면 -4
                                                                                    item.quality-2;   // 그렇지 않다면 -2 감소시킨다.

            // 특수 아이템이고 퀄리티의 최대 값인 50 이하라면 퀄리티를 1씩 증가시킨다.
            if (comparisonRecord.isSpecialAndQualityUnder50()) item.quality++;

            // 특수 아이템 중 백스테이지이면서 판매일이 음수가 아니고 퀄리티가 50 이하일 때 판매일이
            if (comparisonRecord.isBackStageProcess()) {
                if (item.sellIn < 11) item.quality++; // 10 이하면 퀄리티 1를 추가 증가
                if (item.sellIn < 6) item.quality++; //  5이하면 2를 추가 증가
            } else if (comparisonRecord.isBackStageProcessInCaseNegativeSellIn()) item.quality = 0; // 판매일이 음수인 경우 즉, 콘서트 종료 시에는 무조건 0으로 떨어진다.

            // 특수 아이템 중 오래된 브리치즈이면서 판매일이 음수이면서 퀄리티가 50이하일 때 추가로 퀄리티가 1씩 추가 증가한다.
            if (comparisonRecord.isAgedBrieProcess()) item.quality++;

            // 전설 아이템을 제외한 모든 아이템의 판매일을 1씩 감소시킨다.
            item.sellIn--;
        }
    }
}
