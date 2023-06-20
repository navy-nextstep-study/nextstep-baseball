package com.nextstep.baseball.domain;

import java.util.List;
import java.util.stream.IntStream;

public class BaseballCounter {

    public static final int NUMBERS_SIZE = 3;

    public static BaseballStatus compareNumbers(BaseballNumbers playerNumbers, BaseballNumbers answers) {
        List<BaseballNumber> playerNumberList = playerNumbers.getBaseballNumbers();
        List<BaseballNumber> answerList = answers.getBaseballNumbers();

        int strikes = (int) IntStream.range(0, NUMBERS_SIZE)
                .filter(i -> playerNumberList.get(i).isStrike(answerList.get(i)))
                .count();

        int balls = (int) IntStream.range(0, NUMBERS_SIZE)
                .filter(i -> !playerNumberList.get(i).isStrike(answerList.get(i)) &&
                        containsNumber(playerNumberList.get(i), answerList))
                .count();

        return new BaseballStatus(strikes, balls);
    }

    private static boolean containsNumber(BaseballNumber playerNumber, List<BaseballNumber> answerList) {
        return answerList.stream()
                .anyMatch(answer -> answer.isBall(playerNumber));
    }
}
