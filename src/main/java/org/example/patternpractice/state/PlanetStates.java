package org.example.patternpractice.state;

import java.util.HashMap;
import java.util.Map;

public record PlanetStates(int key) {
    private final static Map<Integer, PlanetState> stateMap = new HashMap<>();
    public PlanetStates {
        stateMap.put(0, new Sun());
        stateMap.put(1, new Moon());
    }
    public PlanetState getPlanetState(){
        return stateMap.get(key);
    }
}
