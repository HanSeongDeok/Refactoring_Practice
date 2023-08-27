package org.example.designpattern.practice.function;

public interface DefineTerminateComposite {
    public static final String DescriptionLabel = "Description Common Label";
    public static final String CoreLabel = "Description Common Label";
    public static final String FaultTypeLabel = "Description Common Label";
    public static final String PermanentCB = "Permanent Check Box";
    public static final String DescriptionText = "Description Common Text";
    TextComposite textComposite();
    LabelComposite labelComposite();
    ComboComposite comboComposite();
    WrComboComposite wrComboComposite();
    CheckBoxComposite checkBoxComposite();

    // Impl 객체로 build 패턴을 통해 가져오는 것 또한 가능.
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

    static WrComboComposite getWrComboComposite(){
        return new WrComboComposite() {
            @Override
            public void create(String wrComboTitle) {
                System.out.println(wrComboTitle);
            }
        };
    }
}
