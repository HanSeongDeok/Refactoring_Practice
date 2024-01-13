package org.example.patternpractice.adapt;

import org.example.patternpractice.command.Robot;

public class MultiMoveOrder implements CustomOrder{
    Robot robot;
    int goStep, backStep;
    String direction;
    public MultiMoveOrder(Robot _robot){
        robot = _robot;
    }
    public MultiMoveOrder setStepNumber(int _goStep, int _backStep){
        goStep = _goStep;
        backStep = _backStep;
        return this;
    }
    public MultiMoveOrder setStepDirection(String _direction){
        direction = _direction;
        return this;
    }
    @Override
    public void customRun() {
        robot.go(goStep);
        robot.back(backStep);
        robot.turn(direction);
    }
}
