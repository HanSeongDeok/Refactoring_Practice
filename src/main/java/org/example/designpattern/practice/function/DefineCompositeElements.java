package org.example.designpattern.practice.function;

public interface DefineCompositeElements {
    TextComposite textComposite();
    LabelComposite labelComposite();
    ComboComposite comboComposite();
    WrComboComposite wrComboComposite();
    CheckBoxComposite checkBoxComposite();
    static TextComposite getTextComposite(){
        return new TextComposite() {
            @Override
            public void create(String textTitle) {
                System.out.println(textTitle);
            }
        };
    }
    static LabelComposite getLabelComposite(){
        return new LabelComposite() {
            @Override
            public void create(String labelTitle) {
                System.out.println(labelTitle);
            }
        };
    }
}
