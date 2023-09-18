package org.example.designpattern.decoratorpattern.solutionexample.function;
import org.example.designpattern.decoratorpattern.solutionexample.*;

import java.util.*;

/**
 * 데커레이터 패턴 이벤트 체인 스트림
 */
public interface DisplayStream {
    DisplayDecorator done();
    DisplayStream setLaneDisplay(RoadDisplayMain commonDisplay);
    DisplayStream setCrossingDisplay(RoadDisplayMain commonDisplay);
    DisplayStream setTrafficDisplay(RoadDisplayMain commonDisplay);
    static DisplayStream stream(){
        Display[] displayInParameter = new Display[1];
        return new DisplayStream() {
            @Override
            public DisplayDecorator done() {
                Optional.ofNullable(displayInParameter[0]).orElseThrow(NullPointerException::new);
                return new DisplayDecorator(displayInParameter[0]);
            }
            @Override
            public DisplayStream setLaneDisplay(RoadDisplayMain commonDisplay) {
                if (Optional.ofNullable(displayInParameter[0]).isPresent()) displayInParameter[0] = new LaneDecorator(displayInParameter[0]);
                else displayInParameter[0] = new LaneDecorator(commonDisplay);
                return this;
            }
            @Override
            public DisplayStream setCrossingDisplay(RoadDisplayMain commonDisplay) {
                if (Optional.ofNullable(displayInParameter[0]).isPresent()) displayInParameter[0] = new CrossingDecorator(displayInParameter[0]);
                else displayInParameter[0] = new CrossingDecorator(commonDisplay);
                return this;
            }
            @Override
            public DisplayStream setTrafficDisplay(RoadDisplayMain commonDisplay) {
                if (Optional.ofNullable(displayInParameter[0]).isPresent()) displayInParameter[0] = new TrafficDecorator(displayInParameter[0]);
                else displayInParameter[0] = new TrafficDecorator(commonDisplay);
                return this;
            }
        };
    }
}
