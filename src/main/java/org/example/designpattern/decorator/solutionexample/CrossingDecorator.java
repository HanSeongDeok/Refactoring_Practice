package org.example.designpattern.decorator.solutionexample;

import org.example.designpattern.decorator.solutionexample.function.Display;

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
