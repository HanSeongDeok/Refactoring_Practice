package org.example.refactoring3.tennisgame;

import java.util.Arrays;

public enum SameScoreName {
    LoveAll(0, "Love-All"),
    FifteenAll(1, "Fifteen-All"),
    ThirtyAll(2, "Thirty-All"),
    Deuce(3, "Deuce");

    private int value;
    private String name;

    SameScoreName(int value, String name){
        this.value = value;
        this.name = name;
    }
    public static String getName(int score){
        if (score < 0) throw new IllegalArgumentException("스코어 점수 이상함. 음수가 있어버림.");
        return Arrays.stream(values())
                 .filter(v -> v.value == score)
                 .findFirst()
                 .orElseGet(() -> Deuce).name;
    }
}