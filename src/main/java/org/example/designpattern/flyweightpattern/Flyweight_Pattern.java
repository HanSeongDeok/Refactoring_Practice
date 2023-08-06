package org.example.designpattern.flyweightpattern;

import javax.xml.soap.Text;

public class Flyweight_Pattern {
    static TextEditor textEditor = TextEditor.factory();
    public static void main(String[] args) {
        CharacterFactory.factory()
                .getCharacter('t')
                .display(25);

        new TextEditor(-1).displayText("TEST", -4);
        new TextEditor(-1).displayText("WOW", 4);

        textEditor.displayText("TEST", -2);
        textEditor.displayText("WOW", 2);


    }
}
