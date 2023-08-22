package org.example.designpattern.observerpattern;

import java.util.ArrayList;
import java.util.Comparator;
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
        observers.forEach(o -> o.update(o.toString()));
    }
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
        List<String> test = new ArrayList<>();
        test.stream().sorted(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });
    }
}
