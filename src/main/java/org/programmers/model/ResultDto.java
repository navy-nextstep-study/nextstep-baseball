package org.programmers.model;

public class ResultDto {
    private final int ball;
    private final int strike;

    public ResultDto(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }
}
