package org.example.refactoring3.tennisgame;

public class TennisMultiTeam {
    String player1;
    String player2;
    int score;
    public TennisMultiTeam(String player1, String player2) {
        this.player1 = player1;
        this.player2 = player2;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public int getScore(){
        return score;
    }
    public String getPlayer1() {
        return player1;
    }
    public String getPlayer2() {
        return player2;
    }
}
