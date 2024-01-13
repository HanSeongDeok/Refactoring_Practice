package org.example.patternpractice.command;

public class Robot {
    public void go(int step){
        System.out.println("Go to the " + step +" step");
    }
    public void back(int step){
        System.out.println("Back to the " + step +" step");
    }

    public void turn(String direction) {
        System.out.println("Turn to the " + direction + " direction");
    }
}
