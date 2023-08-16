package org.example.designpattern.visitorpattern;

/**
 * circle area -> Diameter ^ 2 * pi
 * circle perimeter -> Diameter * 2 * pi
 */
public class Circle implements Visitable{
    int diameter;
    double pi = 3.14;
    public Circle(int diameter){
        this.diameter = diameter;
    }
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
