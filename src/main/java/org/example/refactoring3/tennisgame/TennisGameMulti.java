package org.example.refactoring3.tennisgame;

public class TennisGameMulti implements TennisGame{
    private int p2;
    private int p1;
    private TennisTeam team1;
    private TennisTeam team2;

    public TennisTeam getTeam1() {
        return team1;
    }
    public TennisTeam getTeam2() {
        return team2;
    }

    public TennisGameMulti(TennisTeam team1, TennisTeam team2) {
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
