package org.example.patternpractice.strategy;

public class WowButton extends CustomButton{
    private String clickMessage;
    public String getClickMessage(){

        clickMessage = WOW;
        return clickMessage;
    }
}
