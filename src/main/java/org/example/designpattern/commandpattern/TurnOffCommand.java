package org.example.designpattern.commandpattern;

public class TurnOffCommand implements Command{
    TV tv;
    public TurnOffCommand(TV tv) {
        this.tv = tv;
    }
    @Override
    public void execute() {
        tv.turnOff();
    }
}
