package com.nextstep.baseball.domain;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class Computer {

    public static final int NUMBERS_SIZE = 3;
    public static final int MIN = 1;
    public static final int MAX = 9;

    public static Numbers answer;

    static {
        answer = new Numbers(ThreadLocalRandom.current().ints(MIN, MAX + 1)
                .distinct()
                .limit(NUMBERS_SIZE)
                .boxed()
                .collect(Collectors.toList()));
    }
}
