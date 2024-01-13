package org.example.patternpractice.strategy;

import java.util.HashMap;
import java.util.Map;

public record CustomButtons(int key) {
    static private final Map<Integer, CustomButton> customButtonMap = new HashMap<>();
    public CustomButtons {
        customButtonMap.put(0, new TestButton());
        customButtonMap.put(1, new GoodButton());
        customButtonMap.put(2, new WowButton());
    }
    public CustomButton getCustomButton() {
        return customButtonMap.get(key);
    }
}
