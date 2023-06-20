package com.nextstep.baseball.domain;

import java.util.List;

public class Numbers {

    public static void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != 3) {
            throw new IllegalArgumentException("3자리 숫자여야 합니다.");
        }
    }
}
