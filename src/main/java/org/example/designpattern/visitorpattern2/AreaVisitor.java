package org.example.designpattern.visitorpattern2;

public class AreaVisitor implements Visitor{
    @Override
    public double visit(Square square) {
        return square.getX1() * square.getX1();
    }
    @Override
    public double visit(Rectangle rectangle) {
        return rectangle.getX1() * rectangle.getY1();
    }
}
