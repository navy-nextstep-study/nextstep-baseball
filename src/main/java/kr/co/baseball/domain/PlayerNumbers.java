package kr.co.baseball.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PlayerNumbers {

    private static final int RANGE_MIN = 1;
    private static final int RANGE_MAX = 9;

    private final List<Integer> playerNumbers;

    public PlayerNumbers(List<Integer> playerNumbers) {
        validateHasZero(playerNumbers);
        validateDuplicatedNumbers(playerNumbers);
        validateNumbersSize(playerNumbers);
        validateRangeNumbers(playerNumbers);
        this.playerNumbers = playerNumbers;
    }

    public List<Integer> getPlayerNumbers(){
        return Collections.unmodifiableList(playerNumbers);
    }

    private void validateHasZero(List<Integer> input) {
        if (input.contains(0)) {
            throw new IllegalArgumentException("0을 포함할 수 없습니다.");
        }
    }

    private void validateNumbersSize(List<Integer> input) {
        if (input.size() != 3) {
            throw new IllegalArgumentException("3자리 수만 입력 가능합니다.");
        }
    }

    private void validateDuplicatedNumbers(List<Integer> input) {
        List<Integer> temp = input.stream()
                .distinct()
                .collect(Collectors.toList());

        if (!input.equals(temp)) {
            throw new IllegalArgumentException("중복된 값은 입력할 수 없습니다.");
        }
    }

    private void validateRangeNumbers(List<Integer> input) {
        boolean isRange = input.stream()
                .allMatch(number -> number >= RANGE_MIN && number <= RANGE_MAX);

        if (!isRange) {
            throw new IllegalArgumentException("1~9 범위의 숫자만 입력 가능합니다.");
        }
    }
}
