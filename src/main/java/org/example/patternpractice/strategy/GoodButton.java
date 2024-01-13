package org.example.patternpractice.strategy;

public class GoodButton extends CustomButton{
    private String clickMessage;
    public String getClickMessage(){
        clickMessage = GOOD;
        return clickMessage;
    }
}
