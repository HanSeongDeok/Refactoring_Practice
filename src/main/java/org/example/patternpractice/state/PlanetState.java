package org.example.patternpractice.state;

public interface PlanetState {
    void changeState(StatePattern state);
    String getStateMessage();
}
