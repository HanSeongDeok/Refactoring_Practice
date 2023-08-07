package org.example.designpattern.adapterpattern.example2;

import org.example.designpattern.adapterpattern.example2.functnion.CalculateArea;
import org.example.designpattern.adapterpattern.example2.functnion.Rectangle;

public class RectangleAdapter implements Rectangle {
    Square square;
    public RectangleAdapter(Square square){
        this.square = square;
    }
    @Override
    public int getWidth() {
        return square.getSideLength();
    }
    @Override
    public int getHeight() {
        return square.getSideLength();
    }
    @Override
    public int getRectangleArea(CalculateArea calculateArea) {
        return calculateArea.calculate(square.getSideLength(), square.getSideLength());
    }
}
