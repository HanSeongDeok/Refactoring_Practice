package org.example.designpattern.visitorpattern2;


public interface Visitor {
    double visit(Square square);
    double visit(Rectangle rectangle);
}
