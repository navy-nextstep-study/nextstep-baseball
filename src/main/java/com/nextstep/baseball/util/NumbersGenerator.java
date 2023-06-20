package com.nextstep.baseball.util;

import com.nextstep.baseball.domain.Numbers;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class NumbersGenerator {

    public static final int NUMBERS_SIZE = 3;
    public static final int MIN = 1;
    public static final int MAX = 9;

    public static Numbers generateNumbers() {
        return new Numbers(ThreadLocalRandom.current().ints(MIN, MAX + 1)
                .distinct()
                .limit(NUMBERS_SIZE)
                .boxed()
                .collect(Collectors.toList()));
    }
}
