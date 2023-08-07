package org.example.designpattern.visitorpattern2;

@FunctionalInterface
public interface Visitable {
    void accept(Visitor visitor);
}
