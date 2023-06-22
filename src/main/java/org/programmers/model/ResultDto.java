package org.programmers.model;

public class ResultDto {
    private final int ball;
    private final int strike;

    public ResultDto(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public boolean is3Strike() {
        return (this.strike == 3);
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }
}
