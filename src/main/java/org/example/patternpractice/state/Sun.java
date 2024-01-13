package org.example.patternpractice.state;

public class Sun implements PlanetState{
    String sun = "SUN";
    @Override
    public void changeState(StatePattern state) {
        state.setPlanetState(this);
        System.out.println("change state: " + sun);
    }
    @Override
    public String getStateMessage() {
        return sun;
    }
}
