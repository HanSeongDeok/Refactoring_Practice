package org.example.refactoring3.tennisgame;

public class TennisGame3 implements TennisGame{

    private int p2;
    private int p1;
    private String p1N;
    private String p2N;

    public TennisGame3(String p1N, String p2N) {
        this.p1N = p1N;
        this.p2N = p2N;
    }
    public String getP1N() {
        return p1N;
    }
    public String getP2N() {
        return p2N;
    }
    public void wonPoint(String playerName) {
        if (playerName.equals("player1")) this.p1 += 1;
        else this.p2 += 1;
    }
    public String getScore() {
        return TennisScoreDelegator.getInstance()
                    .createTennisScoreHandler(this)
                    .getScore(p1, p2);
    }
}
