package org.example.designpattern.practice;

public class TerminateFunction extends TerminateTF{
    public final static int FLAG_TERMINATE_FUNCTION = 2;
    String type;
    protected TerminateFunction(){
        type = "Function";
    }
    public String getType() {
        return type;
    }
}
