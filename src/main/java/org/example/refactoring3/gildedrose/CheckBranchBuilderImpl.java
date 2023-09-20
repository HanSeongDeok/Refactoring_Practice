package org.example.refactoring3.gildedrose;


public class CheckBranchBuilderImpl implements CheckBranchBuilder{
    private boolean isQualityUnderFifty;
    private boolean isTAFKAL80ETC;
    private boolean isSellinUnderEleven;
    private boolean isSellinUnderSix;
    public boolean isQualityUnderFifty() {return isQualityUnderFifty;}
    public boolean isTAFKAL80ETC() {return isTAFKAL80ETC;}
    public boolean isSellinUnderEleven() {return isSellinUnderEleven;}
    public boolean isSellinUnderSix() {return isSellinUnderSix;}
    private CheckBranchBuilderImpl(){}
    public static CheckBranchBuilder builder(){
        return new CheckBranchBuilderImpl();
    }
    @Override
    public CheckBranchBuilderImpl setIsQualityUnderFifty(boolean check) {
        isQualityUnderFifty = check;
        return this;
    }
    @Override
    public CheckBranchBuilderImpl setIsTAFKAL80ETC(boolean check) {
        isTAFKAL80ETC = check;
        return this;
    }
    @Override
    public CheckBranchBuilderImpl setIsSellinUnderEleven(boolean check) {
        isSellinUnderEleven = check;
        return this;
    }
    @Override
    public CheckBranchBuilderImpl setIsSellinUnderSix(boolean check) {
        isSellinUnderSix = check;
        return this;
    }
    @Override
    public CheckBranchBuilderImpl done() {
        //TODO Validation
        return this;
    }
}
