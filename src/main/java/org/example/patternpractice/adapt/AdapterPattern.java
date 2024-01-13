package org.example.patternpractice.adapt;

import org.example.patternpractice.command.*;

public class AdapterPattern {
    private CommandPattern commandPattern;
    public AdapterPattern addCommandList(CommandPattern _commandPattern, Robot a){
        commandPattern = _commandPattern;
        commandPattern.addList(new GoCommand(a).setStep(1),
                new BackCommand(a).setStep(2),
                new TurnCommand(a).setStep("Right"),
                new CommandAdapter(getCustomOrder(a)));
        return this;
    }
    private CustomOrder getCustomOrder(Robot a) {
        return new MultiMoveOrder(a)
                .setStepNumber(100,200)
                .setStepDirection("UP");
    }
    public void printCommandMessage(){
        commandPattern.commandStart();
    }
    public static void main(String[] args) {
        new AdapterPattern()
                .addCommandList(new CommandPattern(), new Robot())
                .printCommandMessage();
    }
}
