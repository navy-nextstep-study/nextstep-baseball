package kr.co.baseball.domain;

import kr.co.baseball.dto.ResponseDTO;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NumbersComparator {

    private static final int BEGIN_INDEX = 0;
    private static final int END_INDEX = 2;
    private static final int SAME = 1;
    private static final int NOT_SAME = 0;

    public ResponseDTO compare(Computer computer,
                               Player player) {
        final int strike = calculateStrike(computer, player);
        final int ball = calculateBall(computer, player, strike);

        return ResponseDTO.builder()
                .strike(strike)
                .ball(ball)
                .build();
    }

    private int calculateStrike(Computer computer,
                                Player player) {
        return IntStream.rangeClosed(BEGIN_INDEX, END_INDEX)
                .map(i -> checkStrike(computer.get(i), player.get(i)))
                .sum();
    }

    private int checkStrike(int computerNumber,
                            int playerNumber) {
        if (computerNumber == playerNumber) {
            return SAME;
        }

        return NOT_SAME;
    }

    private int calculateBall(Computer computer,
                              Player player,
                              int strike) {
        final int duplicatedRemoveSize = Stream.of(computer.getNumbers(), player.getNumbers())
                .flatMap(Collection::stream)
                .collect(Collectors.toSet())
                .size();

        return Numbers.NUMBERS_SIZE + Numbers.NUMBERS_SIZE - duplicatedRemoveSize - strike;
    }
}
