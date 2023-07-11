package baseball.validation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;


class BallValidatorTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 9})
    void 공_번호_1_9(int number) {
        assertThat(BallValidator.validateNumberInRange(number)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 10})
    void 공_범위밖(int number) {
        assertThat(BallValidator.validateNumberInRange(number)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void 공_위치_1_3(int index) {
        assertThat(BallValidator.validateIndexInRange(index)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 4})
    void 공_위치_범위밖(int index) {
        assertThat(BallValidator.validateIndexInRange(index)).isFalse();
    }
}