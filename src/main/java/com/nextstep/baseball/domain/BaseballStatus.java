package com.nextstep.baseball.domain;

public enum BaseballStatus {
    BALL, STRIKE, NOTHING;

    public static BaseballStatus getStatus(BaseballNumber number1, BaseballNumber number2) {
        if (number1.isStrike(number2)) {
            return STRIKE;
        }
        if (number1.isBall(number2)) {
            return BALL;
        }
        return NOTHING;
    }
}
