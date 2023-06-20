package baseball.domain.ball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BallNumberTest {

    @ParameterizedTest
    @ValueSource(strings = {"a", "$", "z", "ㅋ", "A", "Z"})
    void 볼_넘버_숫자_아닐경우_예외(String input) {
        Assertions.assertThatThrownBy(() -> new BallNumber(input))
                .hasMessageContaining("1 ~ 9 사이의 숫자만 입력이 가능합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "10"})
    void 볼_넘버_숫자_범위_예외(String input) {
        Assertions.assertThatThrownBy(() -> new BallNumber(input))
                .hasMessageContaining("1 ~ 9 사이의 숫자만 입력이 가능합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4", "5", "6", "7", "8", "9"})
    void 볼_넘버_정상_생성(String input) {
        Assertions.assertThatCode(() -> new BallNumber(input))
                .doesNotThrowAnyException();
    }
}