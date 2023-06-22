package kr.co.baseball.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Numbers {
    public static final int RANGE_MIN = 1;
    public static final int RANGE_MAX = 9;
    public static final int NUMBERS_SIZE = 3;
    public static final int NUMBERS_ZERO = 0;

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

    public int get(int index) {
        return Collections.unmodifiableList(numbers).get(index);
    }

    public boolean contains(int value) {
        return Collections.unmodifiableList(numbers).contains(value);
    }

    private void validateHasZero(List<Integer> input) {
        if (input.contains(NUMBERS_ZERO)) {
            throw new IllegalArgumentException("0을 포함할 수 없습니다.");
        }
    }

    private void validateNumbersSize(List<Integer> input) {
        if (input.size() != NUMBERS_SIZE) {
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
