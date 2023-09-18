package org.example.designpattern.decoratorpattern.badexample;

public class RoadDisplayWithLaneTraffic extends RoadDisplay{
    @Override
    public void draw() {
        new RoadDisplayWithLane().draw();
        displayTraffic();
    }
    public void displayTraffic(){
        System.out.println("Display Traffic");
    }
}
