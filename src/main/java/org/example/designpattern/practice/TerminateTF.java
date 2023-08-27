package org.example.designpattern.practice;

import org.example.designpattern.practice.function.DefineCompositeElements;
import org.example.designpattern.practice.function.LabelComposite;
import org.example.designpattern.practice.function.TextComposite;

public abstract class TerminateTF {
    public String Label = "Common Label Setting Done";
    public String Text = "Common Text Setting Done";
    public String Combo = "Common Combo Done";
    public String WrCombo = "Common WrCombo Done";
    public String CheckBox = "Common CheckBox Done";
    public static String faultInjectionType;
    private static TerminateTF terminateTF;
    public static TerminateTF factory(int flagCode){
        // flag == 1
        if (flagCode == TerminateTask.FLAG_TERMINATE_TASK) terminateTF = new TerminateTask();
        // flag == 2
        if (flagCode == TerminateFunction.FLAG_TERMINATE_FUNCTION) terminateTF = new TerminateFunction();
        settingFaultInjectionType(terminateTF);
        return terminateTF;
    }
    private static void settingFaultInjectionType(TerminateTF terminateTF) {
        faultInjectionType = terminateTF.getType();
    }
    public String getFaultInjectionType() {
        if (faultInjectionType.isEmpty()) throw new IllegalStateException();
        return faultInjectionType;
    }
    public void createDescription(){
        TextComposite text = DefineCompositeElements.getTextComposite();
        LabelComposite label = DefineCompositeElements.getLabelComposite();
        text.create(Text);
        label.create(Label);
    }
    //TODO

    public void createCoreInfo(){}
    public void createFaultType(){}
    public void isCheckedPermanent(){}

    public abstract String getType();
}
