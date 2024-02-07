package org.example.patternpractice.flyweight;

public class Client {
    public static void main(String[] args) {
        Symbol symbol = SymbolFactory.getSymbol(1L);
        symbol.printSymbolEntries("a");

        symbol = SymbolFactory.getSymbol(2L);
        symbol.printSymbolEntries("a");

        symbol = SymbolFactory.getSymbol(1L);
        symbol.printSymbolEntries("b");

        System.out.println(SymbolFactory.symbolMap.size());
    }
}
