package kr.co.baseball.domain;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class Computer {
    private static final int NUMBERS_SIZE = 3;
    private static final int RANGE_MIN = 1;
    private static final int RANGE_UNDER_MAX = 10;

    private final Numbers numbers;

    public Computer() {
        final ThreadLocalRandom random = ThreadLocalRandom.current();
        final List<Integer> numbers = random.ints(RANGE_MIN, RANGE_UNDER_MAX)
                .distinct()
                .limit(NUMBERS_SIZE)
                .boxed()
                .collect(Collectors.toList());

        this.numbers = new Numbers(numbers);
    }

    public List<Integer> getNumbers() {
        return this.numbers.getNumbers();
    }
}
