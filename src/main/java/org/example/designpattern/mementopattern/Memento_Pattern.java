package org.example.designpattern.mementopattern;

public class Memento_Pattern {
    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor();
        textEditor.writeText("Hello ");
        System.out.println("Text: " + textEditor.getText());

        textEditor.writeText("World!");
        System.out.println("Text: " + textEditor.getText());

        textEditor.undo();
        System.out.println("Text: " + textEditor.getText());
    }
}
