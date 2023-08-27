package org.example.designpattern.practice;

public class main {
    public static void main(String[] args) {
        TerminateTask task = new TerminateTask();
        TerminateTF test = task;
        test.createFaultType();

        TerminateTF.factory(2).createFaultType();
        TerminateTF.factory(1).createDescription();

    }
}
