package org.example.refactoring3.tennisgame.handler;

import org.example.refactoring3.tennisgame.TennisTeam;

public interface TennisHandler {
    String getScoreResult(int score1, int score2);
    String getScoreResult(TennisTeam team1, TennisTeam team2);
}
