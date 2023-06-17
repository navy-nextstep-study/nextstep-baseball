package kr.co.baseball.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Numbers {
    private static final int RANGE_MIN = 1;
    private static final int RANGE_MAX = 9;

    private final List<Integer> numbers;

    public Numbers(List<Integer> numbers) {
        validateHasZero(numbers);
        validateDuplicatedNumbers(numbers);
        validateNumbersSize(numbers);
        validateRangeNumbers(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
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
        final List<Integer> temp = input.stream()
                .distinct()
                .collect(Collectors.toList());

        if (!input.equals(temp)) {
            throw new IllegalArgumentException("중복된 값은 입력할 수 없습니다.");
        }
    }

    private void validateRangeNumbers(List<Integer> input) {
        final boolean isRange = input.stream()
                .allMatch(number -> number >= RANGE_MIN && number <= RANGE_MAX);

        if (!isRange) {
            throw new IllegalArgumentException("1~9 범위의 숫자만 입력 가능합니다.");
        }
    }
}
