package org.example.patternpractice.state;

public class Moon implements PlanetState{
    String moon = "MOON";
    @Override
    public void changeState(StatePattern state) {
        state.setPlanetState(this);
        System.out.println("change state: " + moon);
    }
    @Override
    public String getStateMessage() {
        return moon;
    }
}
