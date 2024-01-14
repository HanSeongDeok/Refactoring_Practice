package org.example.refactoring3.tennisgame;

public class TennisScoreDelegate {
    private final String[] SCORE_NAMES = {"Love", "Fifteen", "Thirty", "Forty"};
    private String scoreResult;
    private TennisScoreDelegate(){}
    private static TennisScoreDelegate delegator;
    public static TennisScoreDelegate getInstance(){
        return delegator == null ?
                new TennisScoreDelegate() :
                delegator;
    }
    public TennisScoreDelegate compareScore(int score1, int score2) {
        if (score1 < 0 || score2 < 0) throw new IllegalArgumentException("스코어 점수 이상함. 음수가 있어버림.");
        boolean isSameScore = score1 == score2;
        boolean isMatchPointScore = score1 >= 4 || score2 >= 4;
        if (isSameScore) {
            scoreResult = SameScoreName.getName(score1);
        }
        else if (isMatchPointScore) {
            scoreResult = new ScoreRecord(score1, score2).resultMessage();
        }
        else scoreResult = SCORE_NAMES[score1] + "-" + SCORE_NAMES[score2];
        return this;
    }
    public String invokeScoreResult(){
        return scoreResult;
    }
}
// 방법 1 -> Enum 활용, 유지보수 쉬움, 재사용 하기 편함, 구현하기 복잡함
// 방법 2 -> Record 활용(VO로 활용), 단일 책임을 갖는 클래스로 빼내기 쉬움, 유지보수 쉬움, 구현 쉬움, 재사용 하기 편함
// 방법 3 -> 배열 사용 (구현이 편함), 다른 객체에서 재사용하기 어려움