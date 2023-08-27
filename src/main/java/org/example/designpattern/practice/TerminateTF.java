package org.example.designpattern.practice;

import org.example.designpattern.practice.function.*;

public abstract class TerminateTF {
    public static String faultInjectionType;
    public String Combo;
    public String CheckBox;
    private static TerminateTF terminateTF;
    public static TerminateTF factory(int flagCode){
        // flag == 1
        if (flagCode == TerminateTask.FLAG_TERMINATE_TASK) terminateTF = new TerminateTask();
        // flag == 2
        if (flagCode == TerminateFunction.FLAG_TERMINATE_FUNCTION) terminateTF = new TerminateFunction();
        return terminateTF;
    }
    public void createDescription(){
        TextComposite text = DefineTerminateComposite.getTextComposite();
        LabelComposite label = DefineTerminateComposite.getLabelComposite();
        text.create(DefineTerminateComposite.DescriptionText); // contents
        label.create(DefineTerminateComposite.DescriptionLabel); // contents

        DefineTerminateCompositeImpl.builderFactory()
                .setTextComposite(DefineTerminateComposite.DescriptionText)
                .setLabelComposite(DefineTerminateComposite.DescriptionLabel)
                .done();
    }
    //TODO
    public void createCoreInfo(){

    }
    public void createFaultType(){
        LabelComposite label = DefineTerminateComposite.getLabelComposite();
        WrComboComposite wrCombo = DefineTerminateComposite.getWrComboComposite();
        label.create(getType()); // contents
        wrCombo.create(getWrComboContents()); // contents
    }
    public void isCheckedPermanent(){}

    public abstract String getType();
    public abstract String getWrComboContents();
    public abstract int getFlagCode();
}
