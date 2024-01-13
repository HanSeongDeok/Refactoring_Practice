package org.example.patternpractice.command;

public class GoCommand extends RobotCommand{
    int step;
    public GoCommand(Robot _robot) {
        super(_robot);
    }
    public GoCommand setStep(int _step) {
        step = _step;
        return this;
    }
    @Override
    public void execute() {
        robot.go(step);
    }
}
