package org.example.designpattern.decoratorpattern.solutionexample2;

import org.example.designpattern.decoratorpattern.solutionexample2.function.Component;

public abstract class DecoratorObject implements Component {
    private Component component;
    public DecoratorObject(Component component){
        this.component = component;
    }
    @Override
    public void operation() {
        component.operation();
    }
}
