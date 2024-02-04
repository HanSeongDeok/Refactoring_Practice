package org.example.refactoring3.tennisgame;

public class TennisGetScoreHandlerV3 implements TennisGetScoreHandler{
    String player1, player2;
    public TennisGetScoreHandlerV3(TennisGame3 tennisGame3) {
        this.player1 = tennisGame3.getP1N();
        this.player2 = tennisGame3.getP2N();
    }
    @Override
    public String getScore(int score1, int score2) {
        String s;
        if (score1 < 4 && score2 < 4 && !(score1 + score2 == 6)) {
            String[] p = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
            s = p[score1];
            return (score1 == score2) ? s + "-All" : s + "-" + p[score2];
        } else {
            if (score1 == score2)
                return "Deuce";
            s = score1 > score2 ? player1 : player2;
            return ((score1-score2)*(score1-score2) == 1) ? "Advantage " + s : "Win for " + s;
        }
    }
}
