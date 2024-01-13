package org.example.patternpractice.state;

import java.util.stream.IntStream;

public class StatePattern {
    private PlanetState state;
    public StatePattern setPlanetState(PlanetState _state) {
        state = _state;
        return this;
    }
    public void changeState(){
        state.changeState(this);
    }
    public void printStateMessage() {
        changeState();
        System.out.println(state.getStateMessage());
    }

    public static void main(String[] args) {
        IntStream.range(1,11)
                .forEach(StatePattern::printStateMessage);
    }

    private static void printStateMessage(int value) {
        System.out.print("number:"+value +" ");
        new StatePattern()
                .setPlanetState(getPlanetState())
                .printStateMessage();
    }

    private static PlanetState getPlanetState() {
        int randomKey = (int) (Math.random() * 2);
        return new PlanetStates(randomKey).getPlanetState();
    }
}
