package org.example.patternpractice.command;

public class BackCommand extends RobotCommand{
    int step;
    public BackCommand(Robot _robot) {
        super(_robot);
    }
    public BackCommand setStep(int _step) {
        step = _step;
        return this;
    }
    @Override
    public void execute() {
        robot.back(step);
    }
}
