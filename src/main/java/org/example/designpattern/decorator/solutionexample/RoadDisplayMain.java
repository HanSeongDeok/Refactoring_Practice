package org.example.designpattern.decorator.solutionexample;

import org.example.designpattern.decorator.solutionexample.function.Display;

public class RoadDisplayMain implements Display {
    @Override
    public void draw() {
        Display.mainLoad().draw();
    }
}
