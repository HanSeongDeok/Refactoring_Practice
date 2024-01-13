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
        if (score1 < 0 || score2 < 0) throw new IllegalArgumentException("스코어 점수 이상함.");

        if (score1 == score2) scoreResult = getSameScoreResult(score1);
        else if (score1 >= 4 || score2 >= 4) scoreResult = getMatchPointResult(score1, score2);
        else scoreResult = getNormalScoreResult(score1, score2);

        return this;
    }
    public String invokeScoreResult(){
        return scoreResult;
    }

    // 방법 3 -> Enum 활용 유지보수 쉬움, 재사용 하기 편함, 구현하기 복잡함
    private String getSameScoreResult(int score1){
        return SameScoreName.getName(score1);
    }

    // 방법 2 -> 레코드 활용 (VO로 활용)
    // 단일 책임을 갖는 클래스로 빼내기 쉬움, 유지보수 쉬움, 재사용 하기 편함
    private String getMatchPointResult(int score1, int score2) {
        return new ScoreRecord(score1, score2).resultMessage();
    }

    // 방법 1 -> 그냥 배열 사용 (구현이 편함)
    private String getNormalScoreResult(int score1, int score2) {
        return SCORE_NAMES[score1] + "-" + SCORE_NAMES[score2];
    }
}
