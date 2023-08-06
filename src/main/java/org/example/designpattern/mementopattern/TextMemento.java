package org.example.designpattern.mementopattern;

public class TextMemento implements GetText{
    private String text;
    public TextMemento(String text){
        this.text = text;
    }
    public String getText() {
        return text;
    }
}
