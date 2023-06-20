package com.nextstep.baseball.domain;

public enum BaseBallStatus {
    BALL, STRIKE, NOTHING;

    public static BaseBallStatus getStatus(Number number1, Number number2) {
        if (number1.isStrike(number2)) {
            return STRIKE;
        }
        if (number1.isBall(number2)) {
            return BALL;
        }
        return NOTHING;
    }
}
