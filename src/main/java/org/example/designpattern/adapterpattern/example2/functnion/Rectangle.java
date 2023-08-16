package org.example.designpattern.adapterpattern.example2.functnion;

import org.example.designpattern.adapterpattern.example2.functnion.CalculateArea;

public interface Rectangle {
    int getWidth();
    int getHeight();
    int getRectangleArea(CalculateArea calculateArea);
}
