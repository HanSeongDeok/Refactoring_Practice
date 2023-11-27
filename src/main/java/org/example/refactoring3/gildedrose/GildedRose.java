package org.example.refactoring3.gildedrose;

class GildedRose{
    Item[] items;
    public GildedRose(Item[] items) {
        this.items = items;
    }
    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            items[i].quality =  checkBranch1Level(i) ? items[i].quality - 1 : checkBranch3LevelNew(i);
            if (isNotSulfuras(i)) items[i].sellIn = items[i].sellIn - 1;
            if (isSellinUnderZero(i)) items[i].quality = isNotAgedBrie(i) ?
                    getQualityValueBy80ZeroSulfuras(i) : getQualityValueByUnderFifty(i);
        }
    }

    private boolean checkBranch1Level(int i) {
        CheckBranchBuilderImpl checkBranchBuilder = getCheckBranchBuilder(i);
        return GildedroseFunctionImpl.eventChain(checkBranchBuilder)
                .check1Level3Raw((isNABrieAndNBStage, isQOZero, isNSulfuras) -> isNABrieAndNBStage && isQOZero && isNSulfuras)
                .isValid1Level3Raw();
    }

    //TODO @Refactoring
    private int checkBranch3LevelNew(int i) {
        CheckBranchBuilderImpl checkBranchBuilder = getCheckBranchBuilder(i);
        GildedroseFunctionImpl.eventChain(checkBranchBuilder)
                .checkOneBooleanBranch(isQUFifty -> {
                    if (isQUFifty) items[i].quality = items[i].quality + 1;
                    return isQUFifty;
                }).checkThreeBooleanBranch((is80ETC, isSUEleven, isQUFifty) -> {
                    if (is80ETC && isSUEleven && isQUFifty) items[i].quality = items[i].quality + 1;
                    return is80ETC && isSUEleven && isQUFifty;
                }).checkTwoBooleanBranch((isSUSix, isQUFifty) -> {
                    if (isSUSix && isQUFifty) items[i].quality = items[i].quality + 1;
                    return isSUSix && isQUFifty;
                }).done();
        return items[i].quality;
    }

    private CheckBranchBuilderImpl getCheckBranchBuilder(int i) {
        return CheckBranchBuilderImpl.builder()
                .setIsQualityUnderFifty(isQualityUnderFifty(i))
                .setIsSellinUnderSix(isSellinUnderSix(i))
                .setIsTAFKAL80ETC(isTAFKAL80ETC(i))
                .setIsSellinUnderEleven(isSellinUnderEleven(i))
                .setIsQualityOverZero(isQualityOverZero(i))
                .setIsNotAgedBrieAndNotBackStage(isNotAgedBrieAndNotBackStage(i))
                .setIsNotSulfuras(isNotSulfuras(i))
                .done();
    }

    private int getQualityValueByUnderFifty(int i) {
        return isQualityUnderFifty(i) ? items[i].quality + 1 : items[i].quality;
    }

    private int getQualityValueBy80ZeroSulfuras(int i) {
        return (!isTAFKAL80ETC(i) && isQualityOverZero(i) && isNotSulfuras(i))
                ? items[i].quality - 1 : 0;
    }
    private boolean isSellinUnderZero(int i) {
        return items[i].sellIn < 0;
    }
    private boolean isNotAgedBrie(int i) {
        return !items[i].name.equals("Aged Brie");
    }
    private boolean isSellinUnderSix(int i) {
        return items[i].sellIn < 6;
    }
    private boolean isSellinUnderEleven(int i) {
        return items[i].sellIn < 11;
    }
    private boolean isTAFKAL80ETC(int i) {
        return items[i].name.equals("Backstage passes to a TAFKAL80ETC concert");
    }
    private boolean isQualityUnderFifty(int i) {
        return items[i].quality < 50;
    }
    private boolean isNotSulfuras(int i) {
        return !items[i].name.equals("Sulfuras, Hand of Ragnaros");
    }
    private boolean isQualityOverZero(int i) {
        return items[i].quality > 0;
    }
    private boolean isNotAgedBrieAndNotBackStage(int i) {return isNotAgedBrie(i) && !isTAFKAL80ETC(i);}

    // @Deprecated
    /*private int checkBranch3LevelOld(int i) {
        if (isQualityUnderFifty(i)) {
            items[i].quality = items[i].quality + 1;
            if (isTAFKAL80ETC(i) && isSellinUnderEleven(i) && isQualityUnderFifty(i)) {
                items[i].quality = items[i].quality + 1;
                if (isSellinUnderSix(i) && isQualityUnderFifty(i)) {
                    items[i].quality = items[i].quality + 1;
                }
            }
        }
        return items[i].quality;
    }*/
}
