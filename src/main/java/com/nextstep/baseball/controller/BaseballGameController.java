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
}
