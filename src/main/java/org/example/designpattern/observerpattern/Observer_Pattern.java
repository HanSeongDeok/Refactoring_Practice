package org.example.designpattern.observerpattern;

public class Observer_Pattern {
    public static void main(String[] args) {
        Subject subject = new Subject();

        Observer observer1 = new ConcreteObserver("Observer 1");
        Observer observer2 = new ConcreteObserver("Observer 2");

        subject.addObserver(observer1);
        subject.addObserver(observer2);
        subject.printObservers();

        subject.notifyObservers("Hello, observers!");
    }
}
