package org.example.refactoring3.gildedrose;

public interface CheckBranchBuilder {
    CheckBranchBuilderImpl setIsQualityUnderFifty(boolean check);
    CheckBranchBuilderImpl setIsTAFKAL80ETC(boolean check);
    CheckBranchBuilderImpl setIsSellinUnderEleven(boolean check);
    CheckBranchBuilderImpl setIsSellinUnderSix(boolean check);
    CheckBranchBuilderImpl setIsNotAgedBrieAndNotBackStage(boolean check);
    CheckBranchBuilderImpl setIsQualityOverZero(boolean check);
    CheckBranchBuilderImpl setIsNotSulfuras(boolean check);
    CheckBranchBuilderImpl done();
}
