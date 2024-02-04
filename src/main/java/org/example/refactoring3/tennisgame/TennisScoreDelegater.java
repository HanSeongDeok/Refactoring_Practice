package org.example.refactoring3.tennisgame;

public class TennisScoreDelegater implements TennisGetScoreHandler{
    private TennisGetScoreHandler handler;
    private String scoreResult;
    private static TennisScoreDelegater instance;
    int score1,  score2;
    public static TennisScoreDelegater getInstance(){
        return instance == null ?
                new TennisScoreDelegater() :
                instance;
    }
    public TennisScoreDelegater createTennisScoreHandler(TennisGame1 tennisGame1) {
        handler = new TennisGetScoreHandlerV1(tennisGame1);
        return this;
    }
    public TennisScoreDelegater createTennisScoreHandler(TennisGame3 tennisGame3) {
        handler = new TennisGetScoreHandlerV3(tennisGame3);
        return this;
    }
    @Override
    public String getScore(int score1, int score2) {
        // if (handler == null) 에외 처리
        return handler.getScore(score1, score2);
    }
}