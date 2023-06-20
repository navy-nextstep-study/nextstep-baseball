package baseball.validation;

import baseball.domain.ball.BallGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BallGeneratorValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"12", "1478", ""})
    void 공_생성_길이_불일치(String input) {
        assertThatThrownBy(() -> BallGeneratorValidator.validateBall(input))
                .hasMessageContaining("볼의 개수는 " + BallGenerator.BALL_COUNT + "이여야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"a18", "$da", "02A"})
    void 공_입력값_숫자아님(String input) {
        assertThatThrownBy(() -> BallGeneratorValidator.validateBall(input))
                .hasMessageContaining("각 수는 1 ~ 9 사이의 숫자만 입력이 가능합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"557", "224", "339"})
    void 공_중복값_존재(String input) {
        assertThatThrownBy(() -> BallGeneratorValidator.validateBall(input))
                .hasMessageContaining("각 수는 중복되지 않은 숫자여야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "456", "789"})
    void 공_정상값_생성(String input) {
        Assertions.assertThatCode(() -> BallGeneratorValidator.validateBall(input))
                .doesNotThrowAnyException();
    }
}