package baseball.domain.ball;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BallIndexTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 4})
    void 볼_인덱스_예외발생(int input) {
        assertThatThrownBy(() -> new BallIndex(input))
                .hasMessageContaining("index의 범위는 1 ~ 3 이여야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void 볼_인덱스_정상(int input) {
        assertThatCode(() -> new BallIndex(input))
                .doesNotThrowAnyException();
    }
}