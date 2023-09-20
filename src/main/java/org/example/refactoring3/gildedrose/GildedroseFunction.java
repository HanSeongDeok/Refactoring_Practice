package org.example.refactoring3.gildedrose;

import org.example.refactoring3.gildedrose.funtioninterfaces.CheckOneBooleanBranch;
import org.example.refactoring3.gildedrose.funtioninterfaces.CheckThreeBooleanBranch;
import org.example.refactoring3.gildedrose.funtioninterfaces.CheckTwoBooleanBranch;

public interface GildedroseFunction {
    GildedroseFunctionImpl checkOneBooleanBranch(CheckOneBooleanBranch one);
    GildedroseFunctionImpl checkTwoBooleanBranch(CheckTwoBooleanBranch two);
    GildedroseFunctionImpl checkThreeBooleanBranch(CheckThreeBooleanBranch three);
    GildedroseFunctionImpl done();
}
