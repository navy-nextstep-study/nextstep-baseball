package com.nextstep.baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumberTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    @DisplayName("1부터 9까지의 수 검증")
    void validateNumberFrom1To9(int number) {
        assertThat(Number.validate(number)).isTrue();
    }


    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 10, 11})
    @DisplayName("1부터 9까지의 수가 아닌 숫자 검증 에외")
    void validateException(int number) {
        assertThatThrownBy(() -> Number.validate(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1부터 9까지의 수여야 합니다.");
    }
}
