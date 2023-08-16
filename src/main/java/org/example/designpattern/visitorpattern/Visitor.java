package org.example.designpattern.visitorpattern;
public interface Visitor {
    void visit(Circle circle);
    void visit(Rectangle rectangle);
}
