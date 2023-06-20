package com.nextstep.baseball.domain;

public class Number {

    public static final int MIN = 1;
    public static final int MAX = 9;

    public static boolean validate(int num) {
        if (MIN <= num && num <= MAX) {
            return true;
        }
        throw new IllegalArgumentException("1부터 9까지의 수여야 합니다.");
    }
}
