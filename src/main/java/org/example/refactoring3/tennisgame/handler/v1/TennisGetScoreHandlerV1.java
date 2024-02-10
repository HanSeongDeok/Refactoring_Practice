package org.example.refactoring3.tennisgame.handler.v1;

import org.example.refactoring3.tennisgame.TennisGame1;
import org.example.refactoring3.tennisgame.handler.TennisGetScoreHandler;
import org.example.refactoring3.tennisgame.handler.TennisHandlerImpl;

public class TennisGetScoreHandlerV1 extends TennisHandlerImpl {
    private final String[] SCORE_NAMES = {"Love", "Fifteen", "Thirty", "Forty"};
    public TennisGetScoreHandlerV1(TennisGame1 tennisGame1){}
    @Override
    public String getScoreResult(int score1, int score2) {
        illegalExceptionProcess(score1, score2);

        if (score1 == score2) {
            return SameScoreName.getName(score1);
        }
        else if (score1 >= 3 || score2 >= 3) {
            return new ScoreRecord(score1, score2).resultMessage();
        }

        return SCORE_NAMES[score1] + "-" + SCORE_NAMES[score2];
    }

    private static void illegalExceptionProcess(int score1, int score2) {
        if (score1 < 0 || score2 < 0)throw new IllegalArgumentException("스코어 점수 이상함. 음수가 있어버림.");
    }
}
// 방법 1 -> Enum 활용, 유지보수 쉬움, 재사용 하기 편함, 구현하기 복잡함
// 방법 2 -> Record 활용(VO로 활용), 단일 책임을 갖는 클래스로 빼내기 쉬움, 유지보수 쉬움, 구현 쉬움, 재사용 하기 편함
// 방법 3 -> 배열 사용 (구현이 편함), 다른 객체에서 재사용하기 어려움
