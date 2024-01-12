package org.example.refactoring3.tennisgame;

// 두 점수 비교를 통한 결과 반환을 목적으로 하는 VO로 record 활용.
public record ScoreRecord(int score1, int score2) {
    public ScoreRecord{
        if (score1 < 0 || score2 < 0) throw new IllegalArgumentException("스코어 점수가 이상함.");
    }
    public String resultMessage() {
        if (score1 - score2 == 0) throw new IllegalArgumentException("스코어가 같을 때의 서비스 처리는 ScoreRecord 에서 안합니다.");
        return Math.abs(score1 - score2) > 1 ?
                 winnerMessage() :   // 2점차 승리 결정.
                 advantageMessage(); // 1점차 어드벤티지 결정.
    }
    private String winnerMessage() {
        return score1 > score2 ?
                "Win for player1":
                "Win for player2";
    }
    private String advantageMessage() {
        return score1 > score2 ?
                "Advantage player1" :
                "Advantage player2";
    }
}