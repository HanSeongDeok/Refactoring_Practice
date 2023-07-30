package org.example.designpattern.decorator.solutionexample2;

import org.example.designpattern.decorator.solutionexample2.function.Component;

public class ADecorator extends DecoratorObject{
    public ADecorator(Component component) {
        super(component);
    }
    @Override
    public void operation() {
        super.operation();
        additionalOperatingAboutB();
    }
    private void additionalOperatingAboutB() {
        System.out.println("Additional Operating About B");
    }
}
