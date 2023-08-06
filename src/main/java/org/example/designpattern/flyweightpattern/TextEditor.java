package org.example.designpattern.flyweightpattern;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

public class TextEditor {
    private CharacterFactory characterFactory;
    private static TextEditor textEditor;
    private TextEditor(){
        characterFactory = CharacterFactory.factory();
    }
    public TextEditor(int test){characterFactory = CharacterFactory.factory();}
    public static TextEditor factory(){
        return Optional.ofNullable(textEditor).orElseGet(TextEditor::new);
    }
    public void displayText(String text, int fontSize){
        for (char c : text.toCharArray()){
            characterFactory.getCharacter(c).display(fontSize);
        }
    }
}
