package org.example.patternpractice.command;

public class TurnCommand extends RobotCommand{
    String direction;
    public TurnCommand(Robot _robot) {
        super(_robot);
    }
    public TurnCommand setStep(String _direction) {
        direction = _direction;
        return this;
    }
    @Override
    public void execute() {
        robot.turn(direction);
    }
}
