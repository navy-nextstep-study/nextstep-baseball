package camp.nextstep.domain;

import java.util.List;

public class Numbers {

    private final List<Integer> numbers;

    public Numbers(List<Integer> numbers) {
        validateNumbersLength(numbers);
        this.numbers = numbers;
    }

    private void validateNumbersLength(List<Integer> numbers) {
        if (numbers.size() != 3) {
            throw new IllegalArgumentException("입력한 숫자는 3자리가 되어야 합니다.");
        }
    }

    public int[] compareTo(Numbers input, int answerIndex) {
        int strike = 0;
        int ball = 0;
        for (int numberIndex = 0; numberIndex < input.size(); numberIndex++) {
            if (isStrike(input, answerIndex, numberIndex)) {
                strike++;
                continue;
            }

            if (isBall(input, answerIndex, numberIndex)) {
                ball++;
            }
        }
        return new int[]{strike, ball};
    }

    private boolean isStrike(Numbers input, int answerIndex, int numberIndex) {
        return isBall(input, answerIndex, numberIndex) && answerIndex == numberIndex;
    }

    private boolean isBall(Numbers input, int answerIndex, int numberIndex) {
        return numbers.get(answerIndex).equals(input.get(numberIndex));
    }

    public int size() {
        return numbers.size();
    }

    public int get(int index) {
        return numbers.get(index);
    }
}
