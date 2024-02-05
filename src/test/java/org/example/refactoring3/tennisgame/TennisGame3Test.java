package org.example.refactoring3.tennisgame;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TennisGame3Test {
    final static List<TennisGame> tgs = new ArrayList<>();

    @BeforeAll
    static void settingTgs() {
        TennisGame tg = new TennisGame3("player1", "player2");
        tgs.add(tg);
    }

    @Test
    @DisplayName("player1 승리 조건")
    void getScore() {
        TennisGame tg3 = tgs.get(0);
        tg3.wonPoint("player1");
        tg3.wonPoint("player1");
        tg3.wonPoint("player1");
        tg3.wonPoint("player1");

        System.out.println(tg3.getScore());
        assertEquals(tg3.getScore(), "Win for player1");
    }

    @Test
    @DisplayName("player1, player2 듀스조건")
    void getScore2() {
        TennisGame tg3 = tgs.get(0);
        tg3.wonPoint("player1");
        tg3.wonPoint("player2");

        tg3.wonPoint("player1");
        tg3.wonPoint("player2");

        tg3.wonPoint("player1");
        tg3.wonPoint("player2");

        tg3.wonPoint("player1");
        tg3.wonPoint("player2");

        System.out.println(tg3.getScore());
        assertEquals(tg3.getScore(), "Deuce");
    }
}