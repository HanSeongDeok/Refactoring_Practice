package org.example.refactoring3.tennisgame;

import org.example.refactoring3.tennisgame.handler.TennisHandlerImpl;
import org.example.refactoring3.tennisgame.handler.multi.TennisMultiScoreHandlerV1;
import org.example.refactoring3.tennisgame.handler.v1.TennisGetScoreHandlerV1;
import org.example.refactoring3.tennisgame.handler.v3.TennisGetScoreHandlerV3;

public class TennisScoreDelegator{
    /*
     * 이런식의 Facade 객체로 활용하게 되면 OCP 위배 가능성이 존재한다 판단 됨.
     * Template Method 객체를 따로 두어 그 객체만 참조하도록 하여 확장에만 열려있도록 하는게 좋아보임.
     */

    //private TennisGetScoreHandler handler;
    //private TennisMultiScoreHandler multiHandler;
    private TennisHandlerImpl tennisHandler;
    private static TennisScoreDelegator instance;
    public static TennisScoreDelegator getInstance(){
        return instance == null ?
                new TennisScoreDelegator() :
                instance;
    }
    public TennisScoreDelegator createTennisScoreHandler(TennisGame1 tennisGame1) {
        tennisHandler = new TennisGetScoreHandlerV1(tennisGame1);
        return this;
    }
    public TennisScoreDelegator createTennisScoreHandler(TennisGame3 tennisGame3) {
        tennisHandler = new TennisGetScoreHandlerV3(tennisGame3);
        return this;
    }
    public TennisScoreDelegator createTennisScoreHandler(TennisGameMulti tennisGameMulti) {
        tennisHandler = new TennisMultiScoreHandlerV1(tennisGameMulti);
        return this;
    }
    public String getScore(int score1, int score2) {
        return tennisHandler.getScoreResult(score1, score2);
    }
    public String getScore(TennisTeam team1, TennisTeam team2) {
        return tennisHandler.getScoreResult(team1, team2);
    }
}