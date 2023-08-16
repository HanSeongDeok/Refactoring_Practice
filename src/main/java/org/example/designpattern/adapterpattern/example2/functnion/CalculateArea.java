package org.example.designpattern.adapterpattern.example2.functnion;

@FunctionalInterface
public interface CalculateArea {
    int calculate(int height, int width);
    static CalculateArea area() throws ArithmeticException{
        return Math::multiplyExact;
    }
}
