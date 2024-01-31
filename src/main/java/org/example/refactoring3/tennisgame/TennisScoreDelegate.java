package org.example.refactoring3.tennisgame;

public class TennisScoreDelegate implements TennisGetScoreHandler{
    private TennisGetScoreHandler handler;
    private String scoreResult;
    private static TennisScoreDelegate instance;
    public static TennisScoreDelegate getInstance(){
        return instance == null ?
                new TennisScoreDelegate() :
                instance;
    }
    public  TennisScoreDelegate createTennisScoreHandler(TennisGame1 tennisGame1) {
        handler = new TennisGetScoreHandlerV1(tennisGame1);
        return this;
    }
    public  TennisScoreDelegate createTennisScoreHandler(TennisGame3 tennisGame3) {
        handler = new TennisGetScoreHandlerV3(tennisGame3);
        return this;
    }
    public TennisScoreDelegate comparePlayerScore(int score1, int score2)  {
        scoreResult = compareScore(score1, score2);
        return this;
    }
    public String invokeScoreResult(){
        return scoreResult;
    }
    @Override
    public String compareScore(int score1, int score2) {
        // if (handler == null) 에외 처리
        return handler.compareScore(score1, score2);
    }
}