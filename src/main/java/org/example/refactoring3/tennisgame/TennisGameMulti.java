package org.example.refactoring3.tennisgame;

public class TennisGameMulti implements TennisGame{
    private int p2;
    private int p1;
    private TennisMultiTeam team1;
    private TennisMultiTeam team2;

    public TennisMultiTeam getTeam1() {
        return team1;
    }
    public TennisMultiTeam getTeam2() {
        return team2;
    }

    public TennisGameMulti(TennisMultiTeam team1, TennisMultiTeam team2) {
        this.team1 = team1;
        this.team2 = team2;
    }
    @Override
    public void wonPoint(String playerName) {
        if (team1.getPlayer1().equals(playerName) ||
        team1.getPlayer2().equals(playerName)) {
            team1.setScore(++p1);

        } else team2.setScore(++p2);
    }
    @Override
    public String getScore() {
        return TennisScoreDelegator.getInstance()
                .createTennisScoreHandler(this)
                .getScore(team1, team2);
    }
}
