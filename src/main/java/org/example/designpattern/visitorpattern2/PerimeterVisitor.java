package org.example.designpattern.visitorpattern2;

public class PerimeterVisitor implements Visitor{
    @Override
    public double visit(Square square) {
        return square.x1 * 4;
    }
    @Override
    public double visit(Rectangle rectangle) {
        return rectangle.getX1() * 2 + rectangle.getY1() * 2;
    }
}
