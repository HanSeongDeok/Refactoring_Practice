package org.example.designpattern.commandpattern;

public class TurnOnCommand implements Command{
    TV tv;
    public TurnOnCommand(TV tv) {
        this.tv = tv;
    }
    @Override
    public void execute() {
        tv.turnOn();
    }
}
