package org.example.designpattern.observerpattern;

public class ConcreteObserver implements Observer{
    private String message;
    public ConcreteObserver(String message){
        this.message = message;
    }
    public String toString(){
        return message;
    }
    @Override
    public void update(String message) {
        System.out.println("Message " + message);
    }
}
