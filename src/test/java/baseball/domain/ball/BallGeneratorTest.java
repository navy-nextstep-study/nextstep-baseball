package baseball.domain.ball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BallGeneratorTest {

    BallGenerator generator;

    @BeforeEach
    void setUp() {
        generator = new BallGenerator();
    }

    @Test
    void 컴퓨터_볼_생성() {
        for (int i = 0; i < 100; i++) {
            List<Ball> balls = generator.generateBalls();

            long distinctCount = balls
                    .stream()
                    .distinct()
                    .count();

            assertThat(balls.size()).isEqualTo(distinctCount);
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "456", "789", "528"})
    void 입력_볼_생성_정상(String input) {
        List<Ball> balls = generator.generateBalls(input);
        assertThat(balls.size()).isEqualTo(BallGenerator.BALL_COUNT);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a23", "1987", "558"})
    void 입력_볼_생성_예외(String input) {
        List<Ball> balls = generator.generateBalls(input);
        assertThat(balls.size()).isEqualTo(0);
    }
}