package org.example.patternpractice.command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandPattern {
    public List<Command> list = new ArrayList<>();
    public void addList(Command ...command) {
        list.addAll(Arrays.asList(command));
    }
    public void commandStart(){
        list.forEach(Command::execute);
    }
    public static void main(String[] args) {
        Robot a = new Robot();
        CommandPattern commandPattern = new CommandPattern();
        commandPattern.addList(new GoCommand(a).setStep(1),
                                new BackCommand(a).setStep(2),
                                new TurnCommand(a).setStep("Right"));

        commandPattern.commandStart();
    }
}
