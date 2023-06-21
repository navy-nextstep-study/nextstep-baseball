package com.nextstep.baseball.dto;

public class GameResult {
    private int ballCount = 0;
    private int strikeCount = 0;

    public boolean isCorrect() {
        return getStrikeCount() == 3;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public void setBallCount(int ballCount) {
        this.ballCount = ballCount;
    }

    public void setStrikeCount(int strikeCount) {
        this.strikeCount = strikeCount;
    }
}
