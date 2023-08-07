package org.example.designpattern.visitorpattern2;

public class Visitor_Pattern {
    public static void main(String[] args) {
        System.out.println(new AreaVisitor().visit(Rectangle.factory(2, 5)));
        System.out.println(new AreaVisitor().visit(Square.factory(4)));
        System.out.println(new PerimeterVisitor().visit(Rectangle.factory(2, 5)));
        System.out.println(new PerimeterVisitor().visit(Square.factory(4)));

        ShapeCollection shapeCollection = new ShapeCollection();
        shapeCollection.addShape(Square.factory(4));
        shapeCollection.addShape(Rectangle.factory(2, 5));

        System.out.println("---------------------------");

        Visitor areaVisitor = new AreaVisitor();
        shapeCollection.applyVisitor(areaVisitor);

        Visitor perimeterVisitor = new PerimeterVisitor();
        shapeCollection.applyVisitor(perimeterVisitor);
    }
}
