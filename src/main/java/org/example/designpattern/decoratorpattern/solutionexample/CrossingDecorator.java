package org.example.designpattern.decoratorpattern.solutionexample;

import org.example.designpattern.decoratorpattern.solutionexample.function.Display;

public class CrossingDecorator extends DisplayDecorator{
    public CrossingDecorator(Display display){
        super(display);
    }
    @Override
    public void draw() {
        super.draw();
        displayCrossing();
    }
    private void displayCrossing() {
        System.out.println("Display Crossing");
    }
}
