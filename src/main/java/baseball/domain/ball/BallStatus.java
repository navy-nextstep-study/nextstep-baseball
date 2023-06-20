package baseball.domain.ball;

public enum BallStatus {
    STRIKE, BALL, NOTHING;

    public boolean isStrike() {
        return this == BallStatus.STRIKE;
    }

    public boolean isBall() {
        return this == BallStatus.BALL;
    }

    public boolean isNotNothing() {
        return this != BallStatus.NOTHING;
    }
}
