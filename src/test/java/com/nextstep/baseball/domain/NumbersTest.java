package com.nextstep.baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumbersTest {

    @Test
    @DisplayName("자리 수가 3인지 검증")
    void validateNumbersSize() {
        assertThatCode(() -> Numbers.validateNumbersSize(List.of(1, 2, 3)))
                .doesNotThrowAnyException();

        assertThatThrownBy(() -> Numbers.validateNumbersSize(List.of(1, 2, 3, 4)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("3자리 숫자여야 합니다.");
    }
}
