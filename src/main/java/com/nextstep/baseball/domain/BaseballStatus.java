package com.nextstep.baseball.domain;

public class BaseballStatus {

    private final int strikes;
    private final int balls;

    public BaseballStatus(int strike, int ball) {
        this.strikes = strike;
        this.balls = ball;
    }

    public int getStrikes() {
        return strikes;
    }

    public int getBalls() {
        return balls;
    }

    public boolean is3Strikes() {
        return strikes == 3;
    }
}
