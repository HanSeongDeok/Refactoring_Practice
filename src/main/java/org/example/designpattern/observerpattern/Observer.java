package org.example.designpattern.observerpattern;

@FunctionalInterface
public interface Observer {
    void update(String message);
}
