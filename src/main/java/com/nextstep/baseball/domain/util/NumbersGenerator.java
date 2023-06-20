package com.nextstep.baseball.domain.util;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class NumbersGenerator {

    public static final int NUMBERS_SIZE = 3;
    public static final int MIN = 1;
    public static final int MAX = 9;

    public static List<Integer> generateNumbers() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        return random.ints(MIN, MAX + 1)
                .distinct()
                .limit(NUMBERS_SIZE)
                .boxed()
                .collect(Collectors.toList());
    }
}
