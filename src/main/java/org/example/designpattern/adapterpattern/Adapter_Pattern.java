package org.example.designpattern.adapterpattern;

import org.example.designpattern.adapterpattern.example1.LegacyRectangle;
import org.example.designpattern.adapterpattern.example1.RectangleAdapter;
import org.example.designpattern.adapterpattern.example1.RectangleSize;
import org.example.designpattern.adapterpattern.example2.Square;
import org.example.designpattern.adapterpattern.example2.functnion.CalculateArea;
import org.example.designpattern.adapterpattern.example1.function.RectangleSizeBuilder;
import org.example.designpattern.adapterpattern.example1.function.Shape;

public class Adapter_Pattern {
    public static void main(String[] args) {
        RectangleSize size = RectangleSizeBuilder.rectangleStream()
                .setX1(10)
                .setX2(20)
                .setY1(30)
                .setY2(40)
                .setSizeDone();
        Shape shape = new RectangleAdapter(new LegacyRectangle(), size);
        shape.drawShape();
        System.out.println("---------------------------");
        RectangleSize size2 = RectangleSizeBuilder.rectangleStream()
                .setX1(100)
                .setX2(200)
                .setY1(300)
                .setY2(400)
                .setSizeDone();
        Shape shape2 = new RectangleAdapter(new LegacyRectangle(), size2);
        shape2.drawShape();

        Square square = new Square(5);
        org.example.designpattern.adapterpattern.example2.RectangleAdapter rectangleAdapter = new org.example.designpattern.adapterpattern.example2.RectangleAdapter(square);

        int area = rectangleAdapter.getRectangleArea(CalculateArea.area());
        int area2 = rectangleAdapter.getRectangleArea((height, width) -> height * width);
        System.out.println("area: " + area + " area2: " + area2);
        System.out.println(rectangleAdapter.getHeight() + rectangleAdapter.getWidth());
    }
}
