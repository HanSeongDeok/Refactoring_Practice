package org.example.refactoring3.gildedrose;

import org.example.refactoring3.gildedrose.funtioninterfaces.CheckOneBooleanBranch;
import org.example.refactoring3.gildedrose.funtioninterfaces.CheckThreeBooleanBranch;
import org.example.refactoring3.gildedrose.funtioninterfaces.CheckTwoBooleanBranch;

public class GildedroseFunctionImpl implements GildedroseFunction{
    Item[] items;
    @Override
    public GildedroseFunctionImpl checkOneBooleanBranch(CheckOneBooleanBranch one) {
        return this;
    }
    @Override
    public GildedroseFunctionImpl checkTwoBooleanBranch(CheckTwoBooleanBranch two) {
        return this;
    }
    @Override
    public GildedroseFunctionImpl checkThreeBooleanBranch(CheckThreeBooleanBranch three) {
        return this;
    }

}
