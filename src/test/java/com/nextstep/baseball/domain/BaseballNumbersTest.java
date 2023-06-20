package com.nextstep.baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BaseballNumbersTest {

    @Test
    @DisplayName("자리 수가 3인지 검증")
    void validateNumbersSize() {
        assertThatCode(() -> BaseballNumbers.validateNumbersSize(List.of(1, 2, 3)))
                .doesNotThrowAnyException();

        assertThatThrownBy(() -> BaseballNumbers.validateNumbersSize(List.of(1, 2, 3, 4)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("3자리 숫자여야 합니다.");
    }

    @Test
    @DisplayName("1부터 9까지의 수인지 검증")
    void validateNumbersRange() {
        assertThatCode(() -> BaseballNumbers.validateNumbersRange(List.of(1, 2, 3)))
                .doesNotThrowAnyException();

        assertThatThrownBy(() -> BaseballNumbers.validateNumbersRange(List.of(1, 2, 10)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1부터 9까지의 수여야 합니다.");
    }

    @Test
    @DisplayName("중복 숫자 검증")
    void validateNumbersDuplication() {
        assertThatCode(() -> BaseballNumbers.validateNumbersDuplication(List.of(1, 2, 3)))
                .doesNotThrowAnyException();

        assertThatThrownBy(() -> BaseballNumbers.validateNumbersDuplication(List.of(1, 2, 2)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 수가 있습니다.");
    }
}
