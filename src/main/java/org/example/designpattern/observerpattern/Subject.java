package org.example.designpattern.observerpattern;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private List<Observer> observers;
    public Subject(){
        observers = new ArrayList<>();
    }
    public <T extends Observer> void addObserver(T observer) {
        observers.add(observer);
    }
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
    public void printObservers(){
        observers.stream().forEach(o -> o.update(o.toString()));
    }
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}
