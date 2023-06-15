package com.nextstep.baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    void replace(){
        String actual = "abc".replace("b","d");
        assertThat(actual).isEqualTo("adc");
    }
}
