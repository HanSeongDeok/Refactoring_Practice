package org.example.designpattern.decoratorpattern.solutionexample;

import org.example.designpattern.decoratorpattern.solutionexample.function.Display;

public class TrafficDecorator extends DisplayDecorator{
    public TrafficDecorator(Display display) {
        super(display);
    }
    @Override
    public void draw() {
        super.draw();
        displayTraffic();
    }
    private void displayTraffic() {
        System.out.println("Display Traffic");
    }
}
