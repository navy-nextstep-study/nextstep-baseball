package baseball;

import java.util.Objects;

public class Ball {
    private final int index;
    private final int number;

    public Ball(int index, int number) {
        this.index = index;
        this.number = number;
    }

    public BallStatus compare(Ball ball) {
        if (this.equals(ball)) {
            return BallStatus.STRIKE;
        }

        if (this.number == ball.number) {
            return BallStatus.BALL;
        }

        return BallStatus.NOTHING;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return index == ball.index && number == ball.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, number);
    }
}
