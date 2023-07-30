package org.example.designpattern.adapterpattern;

import org.example.designpattern.adapterpattern.function.RectangleSizeBuilder;
import org.example.designpattern.adapterpattern.function.Shape;

public class RectangleAdapter implements Shape {
    private LegacyRectangle legacyRectangle;
    private RectangleSize rectangleSize;
    public RectangleAdapter(LegacyRectangle legacyRectangle, RectangleSize rectangleSize){
        this.legacyRectangle = legacyRectangle;
        this.rectangleSize = rectangleSize;
    }
    @Override
    public void drawShape() {
        legacyRectangle.draw(rectangleSize.x1,rectangleSize.y1,rectangleSize.x2, rectangleSize.y2);
    }
}
