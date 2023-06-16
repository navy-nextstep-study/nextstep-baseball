package baseball.validation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


class BallValidatorTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 9})
    void 공_1_9(int number) {
        Assertions.assertThat(BallValidator.validateNumberInRange(number)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 10})
    void 공_범위밖(int number) {
        Assertions.assertThat(BallValidator.validateNumberInRange(number)).isFalse();
    }
}