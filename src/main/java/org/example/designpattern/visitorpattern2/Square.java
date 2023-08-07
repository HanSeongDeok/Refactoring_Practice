package org.example.designpattern.visitorpattern2;

import java.util.Optional;

public class Square extends Shape implements Visitable{
    int x1;
    private static Square square;
    public int getX1() {
        return x1;
    }
    Square(int x1){
        this.x1 = x1;
    }
    public static Square factory(int x1){
        return Optional.ofNullable(square).orElseGet(()-> buildSquare(x1));
    }
    private static Square buildSquare(int x1) {
        return square = (Square) ShapesFactory.shapeStream()
                .setX1(x1)
                .squareCreate();
    }
    @Override
    public void accept(Visitor visitor) {
        System.out.println(visitor.visit(this));
    }
}
