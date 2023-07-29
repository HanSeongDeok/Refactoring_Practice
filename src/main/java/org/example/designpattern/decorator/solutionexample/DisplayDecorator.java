package org.example.designpattern.decorator.solutionexample;

import org.example.designpattern.decorator.solutionexample.function.Display;

public class DisplayDecorator implements Display {
    Display display;
    public DisplayDecorator(Display display){
        this.display = display;
    }
    @Override
    public void draw() {
        display.draw();
    }
}
