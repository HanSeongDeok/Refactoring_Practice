package org.example.designpattern.flyweightpattern;

public class ConcreteCharacter implements CharacterObject {
    private char c;
    public ConcreteCharacter(char c){
        this.c = c;
    }
    @Override
    public void display(int fontSize) {
        System.out.println("Character: " + c + ", Font Size: " + fontSize);
    }
}
