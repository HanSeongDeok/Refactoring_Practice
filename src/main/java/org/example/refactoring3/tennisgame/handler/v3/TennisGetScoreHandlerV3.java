package org.example.refactoring3.tennisgame.handler.v3;

import org.example.refactoring3.tennisgame.TennisGame3;
import org.example.refactoring3.tennisgame.handler.TennisGetScoreHandler;
import org.example.refactoring3.tennisgame.handler.TennisHandlerImpl;

public class TennisGetScoreHandlerV3 extends TennisHandlerImpl {
    String[] p = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
    String player1, player2;
    int score1, score2;
    public TennisGetScoreHandlerV3(TennisGame3 tennisGame3) {
        this.player1 = tennisGame3.getP1N();
        this.player2 = tennisGame3.getP2N();
    }
    @Override
    public String getScoreResult(int score1, int score2) {
        return isMatchPoint(score1, score2) ?
                getMatchPointResult() :
                getNormalResult();
    }
    private boolean isMatchPoint(int score1, int score2) {
        this.score1 = score1;
        this.score2 = score2;
        return score1 >= 4 || score2 >= 4;
    }
    private String getMatchPointResult() {
        if (score1 == score2) return "Deuce";          // 매치포인트면서 동점일 경우
        return Math.abs(score1 - score2) == 1 ?
                "Advantage " + getWinningPlayer() :   // 매치포인트면서 어드벤티지를 갖는 경우
                "Win for " + getWinningPlayer();          // 승리자가 결정된 경우
    }
    private String getWinningPlayer() {
        return score1 > score2 ?
                player1 :                                     // player1 승리하고 있을 경우
                player2;                                      // player2 승리하고 있을 경우
    }
    private String getNormalResult() {
        return (score1 == score2) ?
                p[score1] + "-All" :                    // 매치포인트가 아니면서 동점일 경우
                p[score1] + "-" + p[score2];     // 매치포인트가 아니면서 동점도 아닐 경우
    }
}
