package org.example.designpattern.practice;

class TerminateTask extends TerminateTF{
    public final static int FLAG_TERMINATE_TASK = 1;
    String type;
    String wrComboContents;
    protected TerminateTask(){
        type = "Task";
        wrComboContents = "Task Symbol List";
    }
    @Override
    public String getType() {
        return type;
    }
    @Override
    public String getWrComboContents() {return wrComboContents;}
    @Override
    public int getFlagCode(){return FLAG_TERMINATE_TASK;}
}
