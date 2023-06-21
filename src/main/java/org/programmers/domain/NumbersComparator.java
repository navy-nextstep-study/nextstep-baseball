package org.programmers.domain;

import org.programmers.model.ResultDto;

import java.util.List;

public class NumbersComparator {
    public static final int NUMBERS_SIZE = 3;

    public ResultDto checkNumber(Numbers numbers, List<Integer> randomNumbers) {
        List<Integer> playerNumbers = numbers.getNumbers();
        int strike = getStrikeCount(randomNumbers, playerNumbers); //스트라이크 개수
        int ball = getBallCount(randomNumbers, playerNumbers, strike);
        System.out.println(strike + " " + ball);

        return new ResultDto(ball, strike);
    }

    private int getStrikeCount(List<Integer> randomNumbers,
                               List<Integer> playerNumbers) {
        int strikeCount = 0;
        for (int i = 0; i < NUMBERS_SIZE; i++) {
            int randomNumber = randomNumbers.get(i);
            int playerNumber = playerNumbers.get(i);
            if (randomNumber == playerNumber) {
                strikeCount += 1;
            }
        }

        return strikeCount;
    }

    private int getBallCount(List<Integer> randomNumbers,
                             List<Integer> playerNumbers,
                             int strike) {

        if (strike >= NUMBERS_SIZE) return 0;

        int answer = 0;
        for (int i = 0; i < NUMBERS_SIZE; i++) {
            for (int j = 0; j < NUMBERS_SIZE; j++) {
                if (randomNumbers.get(i).equals(playerNumbers.get(j))) {
                    answer++;
                }
            }
        }

        return answer - strike;
    }


}


