package baseball.domain.ball;

import java.util.Objects;

public class Ball {
    private final BallIndex ballIndex;
    private final BallNumber number;

    public Ball(int index, int number) {
        this.ballIndex = new BallIndex(index);
        this.number = new BallNumber(number);
    }

    public BallStatus compare(Ball ball) {
        if (this.equals(ball)) {
            return BallStatus.STRIKE;
        }

        if (isEqualsNumber(ball)) {
            return BallStatus.BALL;
        }

        return BallStatus.NOTHING;
    }

    public boolean isEqualsNumber(Ball ball) {
        return this.number.equals(ball.number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return Objects.equals(ballIndex, ball.ballIndex) && Objects.equals(number, ball.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ballIndex, number);
    }
}
