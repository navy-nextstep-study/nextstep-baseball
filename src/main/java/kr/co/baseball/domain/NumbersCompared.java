package kr.co.baseball.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NumbersCompared {
    private static final int BEGIN_INDEX = 0;
    private static final int END_INDEX = 2;
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int COMPUTER_WITH_PLAYER_SIZE = 6;

    public int[] compare(List<Integer> computer,
                         List<Integer> player) {
        int strike = calculateStrike(computer, player);
        int ball = calculateBall(computer, player, strike);

        return new int[]{strike, ball};
    }

    private int calculateStrike(List<Integer> computer,
                                List<Integer> player) {
        return IntStream.rangeClosed(BEGIN_INDEX, END_INDEX)
                .map(i -> checkStrike(computer.get(i), player.get(i)))
                .sum();
    }

    private int checkStrike(int computerNumber,
                            int playerNumber) {
        if (computerNumber == playerNumber) {
            return ONE;
        }

        return ZERO;
    }

    private int calculateBall(List<Integer> computer,
                              List<Integer> player,
                              int strike) {
        int duplicatedRemoveSize = Stream.of(computer, player)
                .flatMap(Collection::stream)
                .collect(Collectors.toSet())
                .size();

        return COMPUTER_WITH_PLAYER_SIZE - duplicatedRemoveSize - strike;
    }
}
