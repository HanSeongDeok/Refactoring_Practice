package org.example.designpattern.practice;

class TerminateFunction extends TerminateTF{
    public final static int FLAG_TERMINATE_FUNCTION = 2;
    String type;
    String wrComboContents;
    protected TerminateFunction(){
        type = "Function";
        wrComboContents = "Function Symbol List";
    }
    @Override
    public String getType() {
        return type;
    }
    @Override
    public String getWrComboContents() {return wrComboContents;}
    @Override
    public int getFlagCode(){return FLAG_TERMINATE_FUNCTION;}
}
