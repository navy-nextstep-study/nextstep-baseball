package baseball.domain.game;

import baseball.domain.ball.Ball;
import baseball.domain.ball.BallGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class RefereeTest {

    Referee referee;
    BallGenerator generator = new BallGenerator();
    List<Ball> computerBalls;

    @BeforeEach
    void setUp() {
        referee = new Referee();
        generator = new BallGenerator();
        computerBalls = Arrays.asList(new Ball(1, 3), new Ball(2, 8), new Ball(3, 7));
    }

    @Test
    void 스트라이크_3() {
        PlayResult result = referee.judgement(computerBalls, generator.generateBalls("387"));
        Assertions.assertThat(result.toString()).isEqualTo("3스트라이크");
    }

    @Test
    void 스트라이크_1_볼_2() {
        PlayResult result = referee.judgement(computerBalls, generator.generateBalls("378"));
        Assertions.assertThat(result.toString()).isEqualTo("2볼 1스트라이크");
    }

    @Test
    void 볼_3() {
        PlayResult result = referee.judgement(computerBalls, generator.generateBalls("738"));
        Assertions.assertThat(result.toString()).isEqualTo("3볼");
    }

    @Test
    void 낫싱() {
        PlayResult result = referee.judgement(computerBalls, generator.generateBalls("145"));
        Assertions.assertThat(result.toString()).isEqualTo("낫싱");
    }
}