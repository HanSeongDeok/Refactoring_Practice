package org.example.designpattern.practice;

public class TerminateTask extends TerminateTF{
    public final static int FLAG_TERMINATE_TASK = 1;
    String type;
    protected TerminateTask(){
        type = "Task";
    }
    public String getType() {
        return type;
    }
}
