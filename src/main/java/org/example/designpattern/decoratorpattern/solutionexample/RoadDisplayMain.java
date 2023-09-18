package org.example.designpattern.decoratorpattern.solutionexample;

import org.example.designpattern.decoratorpattern.solutionexample.function.Display;

public class RoadDisplayMain implements Display {
    @Override
    public void draw() {
        Display.mainLoad().draw();
    }
}
