package com.nextstep.baseball;

import com.nextstep.baseball.domain.util.NumbersGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class NumbersGeneratorTest {

    @Test
    @DisplayName("서로 다른 임의가 숫자 3개 생성")
    void generateDifferentRandomNumbers() {
        List<Integer> generatedNumbers = NumbersGenerator.generateNumbers();
        Set<Integer> numberSet = new HashSet<>(generatedNumbers);
        assertThat(numberSet.size()).isEqualTo(3);
    }
}
