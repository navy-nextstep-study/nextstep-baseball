package com.nextstep.baseball.controller;

import com.nextstep.baseball.domain.BaseballStatus;

public class BaseballGameController {

    public void run() {

    }

    public boolean isGameEnd(BaseballStatus status) {
        if (status.is3Strikes()) {
            return true;
        }
        return false;
    }

    public boolean restartGame(int menu) {
        if (menu == 1) {
            return true;
        }
        if (menu == 2) {
            return false;
        }
        throw new IllegalArgumentException("다시 선택해주세요.");
    }
}
