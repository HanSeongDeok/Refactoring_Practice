package org.example.designpattern.decoratorpattern.badexample;

public class RoadDisplayWithLane extends RoadDisplay{
    @Override
    public void draw() {
        super.draw();
        displayLane();
    }
    private void displayLane() {
        System.out.println("Display Lane");
    }
}
