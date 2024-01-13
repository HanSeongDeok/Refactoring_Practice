package org.example.patternpractice.strategy;

public class TestButton extends CustomButton{
    private String clickMessage;
    public String getClickMessage(){
        clickMessage = TEST;
        return clickMessage;
    }
}
