package org.example.refactoring3.tennisgame;

public class TennisScoreController {
    private final String[] SCORE_NAMES = {"Love", "Fifteen", "Thirty", "Forty"};
    private int score1 = -1;
    private int score2 = -1;
    private ScoreRecord record;
    private TennisScoreController(){}
    private static TennisScoreController referee;
    public static TennisScoreController control(){
        return referee == null ?
                new TennisScoreController() :
                referee;
    }
    public TennisScoreController compareScore(int score1, int score2) {
        this.score1 = score1;
        this.score2 = score2;
        record = new ScoreRecord(score1, score2);
        return this;
    }

    public String invokeScoreResult(){
        if (score1 < 0 || score2 < 0) throw new IllegalArgumentException("스코어 점수 이상함.");
        // 방법 3 -> Enum 활용 유지보수 쉬움, 재사용 하기 편함, 아무래도 정적 final 클래스의 배열이다 보니 비교적 커플링 되어 있다
        if (score1 == score2) return SameScoreName.getName(score1);

        // 방법 2 -> 레코드 활용 (VO로 활용) 
        // 단일 책임을 갖는 클래스로 빼내기 쉬움, 유지보수 쉬움, 재사용 하기 편함
        else if (score1 >=4 || score2 >=4) return record.resultMessage();

        // 방법 1 -> 그냥 배열 사용 (구현이 편함)
        else return resultResolver();
    }

    private String resultResolver() {
        return SCORE_NAMES[score1] + "-" + SCORE_NAMES[score2];
    }
}
