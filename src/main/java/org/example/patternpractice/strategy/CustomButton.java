package org.example.patternpractice.strategy;

public abstract class CustomButton {
    final static String GOOD = "Good";
    final static String TEST = "Test";
    final static String WOW = "Wow";

    abstract String getClickMessage();
}
