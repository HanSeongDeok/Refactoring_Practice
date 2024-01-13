package org.example.patternpractice.command;

public class RobotCommand implements Command{
    Robot robot;
    public RobotCommand(Robot _robot){
        robot = _robot;
    }
    @Override
    public void execute() {
        System.out.println("Not setting the command!");
    }
}
