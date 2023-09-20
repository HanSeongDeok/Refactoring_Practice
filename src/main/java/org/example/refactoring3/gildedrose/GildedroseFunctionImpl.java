package org.example.refactoring3.gildedrose;

import org.example.refactoring3.gildedrose.funtioninterfaces.CheckOneBooleanBranch;
import org.example.refactoring3.gildedrose.funtioninterfaces.CheckThreeBooleanBranch;
import org.example.refactoring3.gildedrose.funtioninterfaces.CheckTwoBooleanBranch;

public class GildedroseFunctionImpl implements GildedroseFunction{
    CheckBranchBuilderImpl checkBranchBuilder;
    private GildedroseFunctionImpl(CheckBranchBuilderImpl checkBranchBuilder) {this.checkBranchBuilder = checkBranchBuilder;}
    public static GildedroseFunctionImpl builder(CheckBranchBuilderImpl checkBranchBuilder) {
        return new GildedroseFunctionImpl(checkBranchBuilder);
    }
    @Override
    public GildedroseFunctionImpl checkOneBooleanBranch(CheckOneBooleanBranch one) {
        one.checkOneBooleanBranch(checkBranchBuilder.isQualityUnderFifty());
        return this;
    }
    @Override
    public GildedroseFunctionImpl checkTwoBooleanBranch(CheckTwoBooleanBranch two) {
        if(!checkBranchBuilder.isQualityUnderFifty()) return this;
        else two.checkOneBooleanBranch(checkBranchBuilder.isQualityUnderFifty(),checkBranchBuilder.isSellinUnderEleven());
        return this;
    }
    @Override
    public GildedroseFunctionImpl checkThreeBooleanBranch(CheckThreeBooleanBranch three) {

        return this;
    }
    @Override
    public GildedroseFunctionImpl done() {
        return null;
    }
}
