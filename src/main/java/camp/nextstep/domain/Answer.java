package camp.nextstep.domain;

import camp.nextstep.dto.BaseballGameResponse;

import java.util.List;

public class Answer {

    private final List<Integer> numbers;

    public Answer(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public BaseballGameResponse compare(List<Integer> input) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < numbers.size(); i++) {
            int[] result = compareNumberTo(input, i);

            strike += result[0];
            ball += result[1];
        }
        return new BaseballGameResponse(strike, ball);
    }

    private int[] compareNumberTo(List<Integer> input, int i) {
        int strike = 0;
        int ball = 0;
        for (int j = 0; j < input.size(); j++) {
            if (isStrike(input, i, j)) {
                strike++;
                continue;
            }

            if (isBall(input, i, j)) {
                ball++;
            }
        }
        return new int[]{strike, ball};
    }

    private boolean isStrike(List<Integer> input, int i, int j) {
        return isBall(input, i, j) && i == j;
    }

    private boolean isBall(List<Integer> input, int i, int j) {
        return numbers.get(i).equals(input.get(j));
    }
}
