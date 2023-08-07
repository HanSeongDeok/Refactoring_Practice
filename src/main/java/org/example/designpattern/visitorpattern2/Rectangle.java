package org.example.designpattern.visitorpattern2;

import java.util.Optional;

public class Rectangle extends Shape implements Visitable{
    private int x1;
    private int y1;
    private static Rectangle rectangle;
    public int getX1() {
        return x1;
    }
    public int getY1() {
        return y1;
    }
    Rectangle(int x1, int y1){
        this.x1 = x1;
        this.y1 = y1;
    }
    public static Rectangle factory(int x1, int y1){
        return Optional.ofNullable(rectangle).orElseGet(()->buildRectangle(x1,y1));
    }
    private static Rectangle buildRectangle(int x1, int y1) {
        return rectangle = (Rectangle) ShapesFactory.shapeStream()
                .setX1(x1)
                .setY1(y1)
                .rectangleCreate();
    }
    @Override
    public void accept(Visitor visitor) {
        System.out.println(visitor.visit(this));
    }
}
