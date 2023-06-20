package com.nextstep.baseball.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Numbers {

    public static final int NUMBERS_SIZE = 3;

    private final List<Number> baseballNumbers;

    public Numbers(List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateNumbersRange(numbers);
        validateNumbersDuplication(numbers);
        this.baseballNumbers = getNumbers(numbers);
    }

    private static List<Number> getNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(Number::new)
                .collect(Collectors.toList());
    }

    public static void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != NUMBERS_SIZE) {
            throw new IllegalArgumentException("3자리 숫자여야 합니다.");
        }
    }

    public static void validateNumbersRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            Number.validate(number);
        }
    }

    public static void validateNumbersDuplication(List<Integer> numbers) {
        Set<Integer> numbersSet = new HashSet<>(numbers);
        if (numbersSet.size() != NUMBERS_SIZE) {
            throw new IllegalArgumentException("중복된 수가 있습니다.");
        }
    }
}
