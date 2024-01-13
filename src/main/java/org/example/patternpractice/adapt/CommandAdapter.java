package org.example.patternpractice.adapt;

import org.example.patternpractice.command.Command;

public class CommandAdapter implements Command {
    CustomOrder customOrder;
    public CommandAdapter(CustomOrder _customOrder){
        customOrder = _customOrder;
    }
    @Override
    public void execute() {
        customOrder.customRun();
    }
}
