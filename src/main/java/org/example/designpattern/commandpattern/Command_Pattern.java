package org.example.designpattern.commandpattern;

public class Command_Pattern {
    public static void main(String[] args) {
        Remote remote = new Remote(new TurnOnCommand(new TV()));
        remote.pressButton();

        Remote remote2 = new Remote(new TurnOffCommand(new TV()));
        remote2.pressButton();
    }
}
