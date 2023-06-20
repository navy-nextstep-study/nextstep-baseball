package baseball.domain.ball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BallNumberTest {


    @ParameterizedTest
    @ValueSource(ints = {0, 10})
    void 볼_넘버_숫자_범위_예외(int input) {
        Assertions.assertThatThrownBy(() -> new BallNumber(input))
                .hasMessageContaining("1 ~ 9 사이의 숫자만 입력이 가능합니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    void 볼_넘버_정상_생성(int input) {
        Assertions.assertThatCode(() -> new BallNumber(input))
                .doesNotThrowAnyException();
    }
}