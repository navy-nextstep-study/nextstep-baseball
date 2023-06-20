package com.nextstep.baseball.domain;

public record BaseballNumber(int position, int number) {

    public static final int MIN = 1;
    public static final int MAX = 9;

    public static boolean validate(int number) {
        if (MIN <= number && number <= MAX) {
            return true;
        }
        throw new IllegalArgumentException("1부터 9까지의 수여야 합니다.");
    }

    @Override
    public int number() {
        return number;
    }

    public boolean isStrike(BaseballNumber number) {
        return this.equals(number);
    }

    public boolean isBall(BaseballNumber number) {
        return this.number == number.number;
    }
}
