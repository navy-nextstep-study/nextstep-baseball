package com.nextstep.baseball.domain;

public record Number(int position, int number) {

    public static final int MIN = 1;
    public static final int MAX = 9;

    public static boolean validate(int num) {
        if (MIN <= num && num <= MAX) {
            return true;
        }
        throw new IllegalArgumentException("1부터 9까지의 수여야 합니다.");
    }

    @Override
    public int number() {
        return number;
    }

    public boolean isStrike(Number number2) {
        return this.equals(number2);
    }

    public boolean isBall(Number number2) {
        return this.number == number2.number;
    }
}
