package org.programmers.domain;

import java.util.Collections;
import java.util.List;

public class Numbers {
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 9;
    private final List<Integer> NUMBERS;

    public Numbers(List<Integer> numbers) {
        validateNumbers(numbers);
        this.NUMBERS = numbers;
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(NUMBERS);
    }

    private void validateNumbers(List<Integer> numbers) {
        validateRange1To9(numbers);
        validateDuplication(numbers);
    }

    private void validateRange1To9(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < MIN_VALUE || number > MAX_VALUE) {
                throw new IllegalArgumentException("1부터 9까지 범위의 수로 이루어져 있지 않습니다.");
            }
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        boolean hasDuplicate = numbers
                .stream()
                .distinct()
                .count() != numbers.size();
        if (hasDuplicate) {
            throw new IllegalArgumentException("중복된 수가 존재합니다.");
        }
    }


}
