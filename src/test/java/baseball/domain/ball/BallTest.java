package baseball.domain.ball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BallTest {

    Ball computerBall;

    @BeforeEach
    void setUp() {
        computerBall = new Ball(1, 3);
    }

    @Test
    void 공_스트라이크() {
        Ball ball = new Ball(1, 3);
        BallStatus status = computerBall.compare(ball);
        Assertions.assertThat(status).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void 공_볼() {
        Ball ball = new Ball(2, 3);
        BallStatus status = computerBall.compare(ball);
        Assertions.assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    void 공_낫띵() {
        Ball ball = new Ball(2, 8);
        BallStatus status = computerBall.compare(ball);
        Assertions.assertThat(status).isEqualTo(BallStatus.NOTHING);
    }
}
