package com.nextstep.baseball.util;

import com.nextstep.baseball.domain.BaseballNumbers;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class BaseballNumbersGanerator {

    public static final int NUMBERS_SIZE = 3;
    public static final int MIN = 1;
    public static final int MAX = 9;

    public BaseballNumbers generateRandomNumbers() {
        return new BaseballNumbers(ThreadLocalRandom.current().ints(MIN, MAX + 1)
                .distinct()
                .limit(NUMBERS_SIZE)
                .boxed()
                .collect(Collectors.toList()));
    }
}
