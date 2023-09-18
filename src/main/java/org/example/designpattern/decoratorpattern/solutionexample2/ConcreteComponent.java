package org.example.designpattern.decoratorpattern.solutionexample2;

import org.example.designpattern.decoratorpattern.solutionexample2.function.Component;

public class ConcreteComponent implements Component {
    @Override
    public void operation() {
        System.out.println("Common Need Basic Operation");
    }
}
