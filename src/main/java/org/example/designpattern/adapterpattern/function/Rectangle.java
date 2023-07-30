package org.example.designpattern.adapterpattern.function;

import org.example.designpattern.adapterpattern.function.CalculateArea;

public interface Rectangle {
    int getWidth();
    int getHeight();
    int getRectangleArea(CalculateArea calculateArea);
}
