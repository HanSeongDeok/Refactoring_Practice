package org.example.designpattern.decorator;

import org.example.designpattern.decorator.badexample.RoadDisplay;
import org.example.designpattern.decorator.badexample.RoadDisplayWithLane;
import org.example.designpattern.decorator.badexample.RoadDisplayWithLaneTraffic;
import org.example.designpattern.decorator.solutionexample.*;

public class Decorator_Pattern {
    public static void main(String[] args) {
        /**
         * BadExample 의 문제점은 또 다른 도로에 표시하려는 기능을 추가하려면
         * RoadDisplay 를 상속받아 Display 안의 상위 객체의 display 기능을 계속 추가해야 한다
         * 즉, 결합도가 높아진다 (OCP 원칙 위배, DIP 원칙 위배)
         * 여러 가지 추가 기능을 조합해 제공하고 싶다면..
         */
        RoadDisplay roadDisplay = new RoadDisplayWithLaneTraffic();
        roadDisplay.draw();
        System.out.println("-------------------------------------------");
        DisplayDecorator displayDecorator = new DisplayDecorator(new RoadDisplayMain());
        displayDecorator.draw();
        System.out.println("-------------------------------------------");
        /**
         * 이런 식으로 데커레이트 패턴을 활용할 수 있다
         */
        DisplayDecorator displayDecorator1 = new DisplayDecorator(
                new LaneDecorator(
                        new CrossingDecorator(
                                new TrafficDecorator(
                                        new RoadDisplayMain()))));
        displayDecorator1.draw();
        System.out.println("-------------------------------------------");
        try {
            DisplayDecorator displayDecorator2 = DisplayStream.stream()
                    .setLaneDisplay(new RoadDisplayMain())
                    .setCrossingDisplay(new RoadDisplayMain())
                    .setTrafficDisplay(new RoadDisplayMain())
                    .done();
            displayDecorator2.draw();
        } catch (NullPointerException e){
            System.out.println("must set basic element");
            e.getStackTrace();
        }
    }
}
