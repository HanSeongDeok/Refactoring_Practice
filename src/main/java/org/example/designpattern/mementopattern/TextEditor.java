package org.example.designpattern.mementopattern;

import java.util.Stack;

public class TextEditor implements GetText{
    private StringBuilder text;
    private Stack<TextMemento> undoStack;

    public TextEditor() {
        text = new StringBuilder();
        undoStack = new Stack<>();
    }

    public void writeText(String newText) {
        undoStack.push(new TextMemento(text.toString()));
        text.append(newText);
    }
    public void undo() {
        if (!undoStack.isEmpty()) {
            TextMemento previousState = undoStack.pop();
            text = new StringBuilder(previousState.getText());
        }
    }
    public String getText(){
        return text.toString();
    }
}
