package org.example.designpattern.visitorpattern2;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollection {
    private List<Visitable> shapes = new ArrayList<>();
    public void addShape(Visitable shape){
        shapes.add(shape);
    }
    public void applyVisitor(Visitor visitor){
        shapes.forEach(s -> s.accept(visitor));

    }
}
