package com.nextstep.baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballStatusTest {

    @Test
    @DisplayName("1자리의 숫자에 대해 1스트라이크")
    void getStrike() {
        BaseballStatus status = BaseballStatus.getStatus(new BaseballNumber(1, 1), new BaseballNumber(1, 1));
        assertThat(status).isEqualTo(BaseballStatus.STRIKE);
    }

    @Test
    @DisplayName("1자리의 숫자에 대해 1볼")
    void getBall() {
        BaseballStatus status1 = BaseballStatus.getStatus(new BaseballNumber(1, 1), new BaseballNumber(2, 1));
        BaseballStatus status2 = BaseballStatus.getStatus(new BaseballNumber(1, 1), new BaseballNumber(3, 1));

        assertThat(status1).isEqualTo(BaseballStatus.BALL);
        assertThat(status2).isEqualTo(BaseballStatus.BALL);
    }

    @Test
    @DisplayName("1자리의 숫자에 대해 1낫띵")
    void getNothing() {
        BaseballStatus status1 = BaseballStatus.getStatus(new BaseballNumber(1, 1), new BaseballNumber(1, 3));
        BaseballStatus status2 = BaseballStatus.getStatus(new BaseballNumber(1, 1), new BaseballNumber(2, 3));
        BaseballStatus status3 = BaseballStatus.getStatus(new BaseballNumber(1, 1), new BaseballNumber(3, 3));

        assertThat(status1).isEqualTo(BaseballStatus.NOTHING);
        assertThat(status2).isEqualTo(BaseballStatus.NOTHING);
        assertThat(status3).isEqualTo(BaseballStatus.NOTHING);
    }
}
