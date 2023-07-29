package org.example.designpattern.decorator.solutionexample;

import org.example.designpattern.decorator.solutionexample.function.Display;

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
