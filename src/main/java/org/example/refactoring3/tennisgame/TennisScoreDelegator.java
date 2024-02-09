package org.example.refactoring3.tennisgame;

import org.example.refactoring3.tennisgame.handler.TennisGetScoreHandler;
import org.example.refactoring3.tennisgame.handler.TennisMultiScoreHandler;
import org.example.refactoring3.tennisgame.handler.multi.TennisMultiScoreHandlerV1;
import org.example.refactoring3.tennisgame.handler.v1.TennisGetScoreHandlerV1;
import org.example.refactoring3.tennisgame.handler.v3.TennisGetScoreHandlerV3;

public class TennisScoreDelegator{
    private TennisGetScoreHandler handler;
    private TennisMultiScoreHandler multiHandler;
    private static TennisScoreDelegator instance;
    public static TennisScoreDelegator getInstance(){
        return instance == null ?
                new TennisScoreDelegator() :
                instance;
    }
    public TennisScoreDelegator createTennisScoreHandler(TennisGame1 tennisGame1) {
        handler = new TennisGetScoreHandlerV1(tennisGame1);
        return this;
    }
    public TennisScoreDelegator createTennisScoreHandler(TennisGame3 tennisGame3) {
        handler = new TennisGetScoreHandlerV3(tennisGame3);
        return this;
    }
    public TennisScoreDelegator createTennisScoreHandler(TennisGameMulti tennisGameMulti) {
        multiHandler = new TennisMultiScoreHandlerV1(tennisGameMulti);
        return this;
    }
    public String getScore(int score1, int score2) {
        return handler.getScoreResult(score1, score2);
    }
    public String getScore(TennisMultiTeam team1,TennisMultiTeam team2) {
        return multiHandler.getScoreResult(team1, team2);
    }
}