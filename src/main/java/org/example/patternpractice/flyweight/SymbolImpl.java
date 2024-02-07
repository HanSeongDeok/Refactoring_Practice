package org.example.patternpractice.flyweight;

public class SymbolImpl implements Symbol{
    long symbolAddr;
    public SymbolImpl(long address){
        this.symbolAddr = address;
    }

    @Override
    public void printSymbolEntries(String memberVar) {
        System.out.println(memberVar + " is involved in "+ symbolAddr);
    }
}
