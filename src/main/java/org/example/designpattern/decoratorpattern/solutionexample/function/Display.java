package org.example.designpattern.decoratorpattern.solutionexample.function;

/**
 * Draw AnyThing For The Making Traffic Load
 */
@FunctionalInterface
public interface Display {
    void draw();
    /**
     * Draw The Main Load
     * @return void
     */
    static Display mainLoad(){
        return ()-> System.out.println("Display Main Load");
    }
}
