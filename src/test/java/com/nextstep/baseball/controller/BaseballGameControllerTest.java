package com.nextstep.baseball.controller;

import com.nextstep.baseball.domain.BaseballStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    @DisplayName("1이 들어오면 게임을 새로 시작")
    void restartGame() {
        assertThat(baseballGameController.restartGame(1)).isTrue();
    }

    @Test
    @DisplayName("2이 들어오면 게임을 완전히 종료")
    void quitGameCompletely() {
        assertThat(baseballGameController.restartGame(2)).isFalse();
    }

    @Test
    @DisplayName("1이나 2 이외에 값이 들어온 경우")
    void otherMenuSelectionException() {
        assertThatThrownBy(() -> baseballGameController.restartGame(3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("다시 선택해주세요.");
    }
}