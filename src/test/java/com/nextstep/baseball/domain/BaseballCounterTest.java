package com.nextstep.baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballCounterTest {

    @Test
    @DisplayName("같은 숫자일 때 스트라이크 3개")
    void sameNumbersAllStrikes() {
        BaseballNumbers playerNumbers = new BaseballNumbers(List.of(1, 2, 3));
        BaseballNumbers answers = new BaseballNumbers(List.of(1, 2, 3));
        BaseballStatus status = BaseballCounter.compareNumbers(playerNumbers, answers);

        assertThat(status.getStrikes()).isEqualTo(3);
        assertThat(status.getBalls()).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자는 같으나 위치가 다를 때 스트라이크 1개, 볼 2개")
    void sameNumbersDifferentPositions() {
        BaseballNumbers playerNumbers = new BaseballNumbers(List.of(1, 2, 3));
        BaseballNumbers answers = new BaseballNumbers(List.of(2, 1, 3));
        BaseballStatus status = BaseballCounter.compareNumbers(playerNumbers, answers);

        assertThat(status.getStrikes()).isEqualTo(1);
        assertThat(status.getBalls()).isEqualTo(2);
    }

    @Test
    @DisplayName("숫자가 전혀 일치하지 않을 때 스트라이크 0개, 볼 0개")
    void noMatchingNumbers() {
        BaseballNumbers playerNumbers = new BaseballNumbers(List.of(1, 2, 3));
        BaseballNumbers answers = new BaseballNumbers(List.of(4, 5, 6));
        BaseballStatus status = BaseballCounter.compareNumbers(playerNumbers, answers);

        assertThat(status.getStrikes()).isEqualTo(0);
        assertThat(status.getBalls()).isEqualTo(0);
    }

}
