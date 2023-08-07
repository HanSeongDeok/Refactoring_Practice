package org.example.designpattern.visitorpattern;

import java.util.Optional;

public class AreaVisitor implements Visitor{
    private Visitable visitable;
    private static AreaVisitor areaVisitor;
    private AreaVisitor(Visitable visitable){
         this.visitable = visitable;
    }
    public static AreaVisitor areaVisitorFactory(Visitable visitable){
        return Optional.ofNullable(areaVisitor).orElseGet(() -> new AreaVisitor(visitable));
    }
    @Override
    public void visit(Circle circle) {

    }
    @Override
    public void visit(Rectangle rectangle) {

    }
}
