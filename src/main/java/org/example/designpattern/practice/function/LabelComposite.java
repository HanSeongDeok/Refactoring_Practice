package org.example.designpattern.practice.function;

@FunctionalInterface
public interface LabelComposite {
    void create(String labelTitle);

    static LabelComposite setting(){
        return new LabelComposite() {
            @Override
            public void create(String labelTitle) {
                System.out.println(labelTitle);
            }
        };
    }
}
