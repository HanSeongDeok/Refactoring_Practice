package org.example.designpattern.adapterpattern.example1.function;

import org.example.designpattern.adapterpattern.example1.RectangleSize;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * RectangleSize 생성자 builder 추상화
 */
public interface RectangleSizeBuilder {
    final String X1 = "x1";
    final String Y1 = "y1";
    final String X2 = "x2";
    final String Y2 = "y2";
    String[] points = {X1, X2, Y1, Y2};
    RectangleSize setSizeDone();
    RectangleSizeBuilder setX1(int x1);
    RectangleSizeBuilder setY1(int y1);
    RectangleSizeBuilder setX2(int x2);
    RectangleSizeBuilder setY2(int y2);
    static RectangleSizeBuilder rectangleStream(){
        Map<String, Integer> map = new HashMap<>();
        return new RectangleSizeBuilder() {
            @Override
            public RectangleSize setSizeDone() {
                if (!Arrays.stream(points).allMatch(map::containsKey)) throw new IllegalStateException("Not All Setting");
                return new RectangleSize(map);
            }
            @Override
            public RectangleSizeBuilder setX1(int x1) {
                map.put(X1,x1);
                return this;
            }
            @Override
            public RectangleSizeBuilder setY1(int y1) {
                map.put(Y1,y1);
                return this;
            }
            @Override
            public RectangleSizeBuilder setX2(int x2) {
                map.put(X2,x2);
                return this;
            }
            @Override
            public RectangleSizeBuilder setY2(int y2) {
                map.put(Y2,y2);
                return this;
            }
        };
    }
}
