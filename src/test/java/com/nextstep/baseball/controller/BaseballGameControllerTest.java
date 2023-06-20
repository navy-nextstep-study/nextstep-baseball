package com.nextstep.baseball.controller;

import com.nextstep.baseball.domain.BaseballStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballGameControllerTest {

    BaseballGameController baseballGameController;

    @BeforeEach
    void setUp() {
        baseballGameController = new BaseballGameController();
    }

    @Test
    @DisplayName("3 스트라이크가 나오면 게임 종료")
    void gameOverOn3Strikes() {
        BaseballStatus status = new BaseballStatus(3, 0);
        assertThat(baseballGameController.isGameEnd(status)).isTrue();
    }

    @Test
    @DisplayName("3 스트라이크가 나오면 게임 종료")
    void continueGame() {
        BaseballStatus status = new BaseballStatus(1, 0);
        assertThat(baseballGameController.isGameEnd(status)).isFalse();
    }
}