package controller;

import kr.co.baseball.controller.BaseballController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballControllerTest {

    @Test
    void runBaseball_게임_시작_TRUE() {
        //given
        BaseballController baseballController = new BaseballController();

        //when
        baseballController.runBaseball();

        //then
        assertThat(baseballController.isRunBaseball()).isTrue();
    }
}
