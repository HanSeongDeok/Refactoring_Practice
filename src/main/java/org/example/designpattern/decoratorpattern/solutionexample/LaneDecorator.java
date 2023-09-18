package org.example.designpattern.decoratorpattern.solutionexample;

import org.example.designpattern.decoratorpattern.solutionexample.function.Display;

public class LaneDecorator extends DisplayDecorator{
    public LaneDecorator(Display display) {
        super(display);
    }
    @Override
    public void draw() {
        super.draw();
        displayLane();
    }
    private void displayLane() {
        System.out.println("Display Lane");
    }
}
