package org.example.designpattern.decoratorpattern.solutionexample;

import org.example.designpattern.decoratorpattern.solutionexample.function.Display;

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
