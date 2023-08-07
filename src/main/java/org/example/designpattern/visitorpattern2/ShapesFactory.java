package org.example.designpattern.visitorpattern2;

public interface ShapesFactory {
    Shape squareCreate();
    Shape rectangleCreate();
    ShapesFactory setX1(int x1);
    ShapesFactory setY1(int y1);

    static ShapesFactory shapeStream(){
        final int X1[] = new int[1];
        final int Y1[] = new int[1];
        return new ShapesFactory() {
            @Override
            public Shape squareCreate() {
                return new Square(X1[0]);
            }
            @Override
            public Shape rectangleCreate(){
                return new Rectangle(X1[0], Y1[0]);
            }
            @Override
            public ShapesFactory setX1(int x1) {
                X1[0] = x1;
                return this;
            }
            @Override
            public ShapesFactory setY1(int y1) {
                Y1[0] = y1;
                return this;
            }
        };
    }
}
