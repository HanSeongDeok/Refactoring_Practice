package org.example.designpattern.decoratorpattern.solutionexample2;

import org.example.designpattern.decoratorpattern.solutionexample2.function.Component;

public class BDecorator extends DecoratorObject{
    public BDecorator(Component component) {
        super(component);
    }
    @Override
    public void operation() {
        super.operation();
        additionalOperatingAboutA();
    }
    private void additionalOperatingAboutA() {
        System.out.println("Additional Operating About A");
    }
}
