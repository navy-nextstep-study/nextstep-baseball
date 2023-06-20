package com.nextstep.baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseBallStatusTest {

    @Test
    @DisplayName("1자리의 숫자에 대해 1스트라이크")
    void getStrike() {
        BaseBallStatus status = BaseBallStatus.getStatus(new Number(1, 1), new Number(1, 1));
        assertThat(status).isEqualTo(BaseBallStatus.STRIKE);
    }

    @Test
    @DisplayName("1자리의 숫자에 대해 1볼")
    void getBall() {
        BaseBallStatus status1 = BaseBallStatus.getStatus(new Number(1, 1), new Number(2, 1));
        BaseBallStatus status2 = BaseBallStatus.getStatus(new Number(1, 1), new Number(3, 1));

        assertThat(status1).isEqualTo(BaseBallStatus.BALL);
        assertThat(status2).isEqualTo(BaseBallStatus.BALL);
    }

    @Test
    @DisplayName("1자리의 숫자에 대해 1낫띵")
    void getNothing() {
        BaseBallStatus status1 = BaseBallStatus.getStatus(new Number(1, 1), new Number(1, 3));
        BaseBallStatus status2 = BaseBallStatus.getStatus(new Number(1, 1), new Number(2, 3));
        BaseBallStatus status3 = BaseBallStatus.getStatus(new Number(1, 1), new Number(3, 3));

        assertThat(status1).isEqualTo(BaseBallStatus.NOTHING);
        assertThat(status2).isEqualTo(BaseBallStatus.NOTHING);
        assertThat(status3).isEqualTo(BaseBallStatus.NOTHING);
    }
}
