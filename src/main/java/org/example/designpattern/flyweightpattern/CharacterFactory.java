package org.example.designpattern.flyweightpattern;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CharacterFactory {
    private Map<Character, CharacterObject> characterMap;
    private static CharacterFactory characterFactory;
    private CharacterFactory() {
        characterMap = new HashMap<>();
    }
    public static CharacterFactory factory(){
        return Optional.ofNullable(characterFactory).orElseGet(CharacterFactory::new);
    }
    public CharacterObject getCharacter(char c){
        characterMap.computeIfAbsent(c, key -> new ConcreteCharacter(c));
        return characterMap.get(c);
    }
}
