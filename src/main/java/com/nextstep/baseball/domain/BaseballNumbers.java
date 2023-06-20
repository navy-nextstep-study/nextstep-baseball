package com.nextstep.baseball.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BaseballNumbers {

    public static final int NUMBERS_SIZE = 3;

    private final List<BaseballNumber> baseballNumbers;

    public BaseballNumbers(List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateNumbersRange(numbers);
        validateNumbersDuplication(numbers);
        this.baseballNumbers = mapNumbers(numbers);
    }

    private static List<BaseballNumber> mapNumbers(List<Integer> numbers) {
        return IntStream.range(0, NUMBERS_SIZE)
                .mapToObj(i -> new BaseballNumber(i + 1, numbers.get(i)))
                .collect(Collectors.toList());
    }

    public static void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != NUMBERS_SIZE) {
            throw new IllegalArgumentException("3자리 숫자여야 합니다.");
        }
    }

    public static void validateNumbersRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            BaseballNumber.validate(number);
        }
    }

    public static void validateNumbersDuplication(List<Integer> numbers) {
        Set<Integer> numbersSet = new HashSet<>(numbers);
        if (numbersSet.size() != NUMBERS_SIZE) {
            throw new IllegalArgumentException("중복된 수가 있습니다.");
        }
    }

    public List<BaseballNumber> getBaseballNumbers() {
        return baseballNumbers;
    }
}
