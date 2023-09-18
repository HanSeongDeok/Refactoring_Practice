package org.example.designpattern.decoratorpattern;

import org.example.designpattern.decoratorpattern.badexample.RoadDisplay;
import org.example.designpattern.decoratorpattern.badexample.RoadDisplayWithLaneTraffic;
import org.example.designpattern.decoratorpattern.solutionexample.*;
import org.example.designpattern.decoratorpattern.solutionexample.function.DisplayStream;

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
        /**
         * 데커레이트와 함수형 프로그래밍 조합 적용 -> 핵심은 super 를 활용하여 매개변수로 들어온 객체를
         * 데커레이트 객체로 보내 다형성을 이용한 draw 매서드를 실행하는 것이 핵심이다.
         */
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
