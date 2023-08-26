package org.example.designpattern.practice;

public abstract class TerminateTF {
    public String Label = "Common Label Setting Done";
    public String Text = "Common Text Setting Done";
    public String description = "Common Description Done";
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

    public abstract String getType();
}
