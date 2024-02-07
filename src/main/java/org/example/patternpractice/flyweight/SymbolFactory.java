package org.example.patternpractice.flyweight;

import javax.swing.text.html.Option;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class SymbolFactory {
    public static final Map<Long, SymbolImpl> symbolMap = new HashMap<>();
    public static Symbol getSymbol(long address){
        if (existSymbol(address)) {
            symbolMap.put(address, new SymbolImpl(address));
        }
        return symbolMap.get(address);
    }
    private static boolean existSymbol(long address) {
        return Optional.ofNullable(symbolMap.get(address)).isEmpty();
    }
}
