package org.example.designpattern.practice.function;

public class DefineTerminateCompositeImpl implements DefineTerminateComposite{
    private static CompositeBuilder builder;
    @Override
    public TextComposite textComposite() {
        return System.out::println;
    }
    @Override
    public LabelComposite labelComposite() {
        return System.out::println;
    }
    @Override
    public ComboComposite comboComposite() {
        return System.out::println;
    }
    @Override
    public WrComboComposite wrComboComposite() {
        return System.out::println;
    }
    @Override
    public CheckBoxComposite checkBoxComposite() {
        return System.out::println;
    }
    private DefineTerminateCompositeImpl(){}
    public static CompositeBuilder builderFactory(){
        if (builder == null) return builder = new CompositeBuilder();
        return builder;
    }
    public static class CompositeBuilder{
        private DefineTerminateCompositeImpl impl;
        private CompositeBuilder(){
            impl = new DefineTerminateCompositeImpl();
        }
        public CompositeBuilder setTextComposite(String textTitle){
            impl.textComposite().create(textTitle);
            return this;
        }
        public CompositeBuilder setLabelComposite(String labelTitle){
            impl.labelComposite().create(labelTitle);
            return this;
        }
        public CompositeBuilder setComboComposite(String comboTitle){
            impl.comboComposite().create(comboTitle);
            return this;
        }
        public CompositeBuilder setWrComboComposite(String wrComboTitle){
            impl.wrComboComposite().create(wrComboTitle);
            return this;
        }
        public CompositeBuilder setCheckBoxComposite(String checkBoxTitle){
            impl.checkBoxComposite().create(checkBoxTitle);
            return this;
        }
        public boolean done() {
            System.out.println("setting done");
            return true;
        }
    }
}
