package org.example.patternpractice.strategy;

public class CustomButtonDelegate {
    CustomButton customButton;
    public CustomButtonDelegate createCustomButton(int key) {
        customButton = new CustomButtons(key).getCustomButton();
        return this;
    }
    public CustomButton getCustomButton(){
        return customButton;
    }
}
