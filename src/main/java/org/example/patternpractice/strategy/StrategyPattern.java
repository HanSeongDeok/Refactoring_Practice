package org.example.patternpractice.strategy;

import java.util.stream.IntStream;

public class StrategyPattern {
    CustomButton customButton;
    public String printStrategyMessage(){
        if (customButton == null) return "Nothing";
        return customButton.getClickMessage();
    }
    public void setCustomButton(CustomButton _customButton){
        customButton = _customButton;
    }
    public int getRandomKey() {
        return (int)(Math.random()*3);
    }
    static StrategyPattern strategyPattern = new StrategyPattern();
    private static void printStrategyMessageByKey(int value) {
        int randomKey = strategyPattern.getRandomKey();
        strategyPattern.setCustomButton(new CustomButtonDelegate()
                                            .createCustomButton(randomKey)
                                            .getCustomButton());
        System.out.println("number"+ (value+1)+": "+ strategyPattern.printStrategyMessage());
    }

    public static void main(String[] args) {
        IntStream.range(0, 10)
                .forEach(StrategyPattern::printStrategyMessageByKey);
    }
}
