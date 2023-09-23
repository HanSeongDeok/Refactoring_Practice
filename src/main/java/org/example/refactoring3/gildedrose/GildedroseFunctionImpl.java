package org.example.refactoring3.gildedrose;

import org.example.refactoring3.gildedrose.funtioninterfaces.CheckOneBooleanBranch;
import org.example.refactoring3.gildedrose.funtioninterfaces.CheckThreeBooleanBranch;
import org.example.refactoring3.gildedrose.funtioninterfaces.CheckTwoBooleanBranch;

public class GildedroseFunctionImpl implements GildedroseFunction{
    private boolean validOne = false;
    private boolean validTwo = false;
    private boolean validThree = false;
    private boolean valid1Level3Raw = false;
    public boolean isValidOne() {return validOne;}
    public boolean isValidTwo() {return validTwo;}
    public boolean isValidThree() {return validThree;}
    public boolean isValid1Level3Raw() {return valid1Level3Raw;}
    CheckBranchBuilderImpl checkBranchBuilder;
    private GildedroseFunctionImpl(CheckBranchBuilderImpl checkBranchBuilder) {this.checkBranchBuilder = checkBranchBuilder;}
    public static GildedroseFunctionImpl eventChain(CheckBranchBuilderImpl checkBranchBuilder) {
        return new GildedroseFunctionImpl(checkBranchBuilder);
    }
    @Override
    public GildedroseFunctionImpl checkOneBooleanBranch(CheckOneBooleanBranch one) {
        one.checkOneBooleanBranch(checkBranchBuilder.isQualityUnderFifty());
        return this;
    }
    @Override
    public GildedroseFunctionImpl checkTwoBooleanBranch(CheckTwoBooleanBranch two) {
        if(isValidThree()) two.checkTwoBooleanBranch(checkBranchBuilder.isSellinUnderSix(),
                checkBranchBuilder.isQualityUnderFifty());
        return this;
    }
    @Override
    public GildedroseFunctionImpl checkThreeBooleanBranch(CheckThreeBooleanBranch three) {
        if(isValidOne()) three.checkThreeBooleanBranch(checkBranchBuilder.isTAFKAL80ETC(),
                checkBranchBuilder.isSellinUnderEleven(),
                checkBranchBuilder.isQualityUnderFifty());
        return this;
    }
    @Override
    public GildedroseFunctionImpl check1Level3Raw(CheckThreeBooleanBranch three) {
        valid1Level3Raw = three.checkThreeBooleanBranch(checkBranchBuilder.isNotAgedBrieAndNotBackStage(),
                checkBranchBuilder.isQualityOverZero(),
                checkBranchBuilder.isNotSulfuras());
        return this;
    }
    @Override
    public GildedroseFunctionImpl done() {
        return null;
    }
}
