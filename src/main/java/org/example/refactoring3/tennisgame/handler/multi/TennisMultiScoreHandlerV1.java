package org.example.refactoring3.tennisgame.handler.multi;

import org.example.refactoring3.tennisgame.TennisGameMulti;
import org.example.refactoring3.tennisgame.TennisMultiTeam;
import org.example.refactoring3.tennisgame.handler.TennisMultiScoreHandler;

public class TennisMultiScoreHandlerV1 implements TennisMultiScoreHandler {
    String[] p = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
    TennisMultiTeam team1;
    TennisMultiTeam team2;
    int score1, score2;
    public TennisMultiScoreHandlerV1(TennisGameMulti tennisGameMulti) {
        this.team1 = tennisGameMulti.getTeam1();
        this.team2 = tennisGameMulti.getTeam2();
    }
    @Override
    public String getScoreResult(TennisMultiTeam team1, TennisMultiTeam team2) {
        return isMatchPoint(team1.getScore(), team2.getScore()) ?
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
                team1.getPlayer1() + "," +team1.getPlayer2() :                                     // player1 승리하고 있을 경우
                team2.getPlayer1() + "," +team2.getPlayer2();                                      // player2 승리하고 있을 경우
    }
    private String getNormalResult() {
        return (score1 == score2) ?
                p[score1] + "-All" :                    // 매치포인트가 아니면서 동점일 경우
                p[score1] + "-" + p[score2];     // 매치포인트가 아니면서 동점도 아닐 경우
    }
}
