package com.nextstep.baseball.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;

public class NumbersGeneratorTest {

    @Test
    @DisplayName("서로 다른 임의가 숫자 3개 생성")
    void generateDifferentRandomNumbers() {
        assertThatCode(() -> NumbersGenerator.generateNumbers())
                .doesNotThrowAnyException();
    }
}
