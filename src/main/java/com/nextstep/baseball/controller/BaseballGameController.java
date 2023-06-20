package com.nextstep.baseball.controller;

import com.nextstep.baseball.domain.BaseballCounter;
import com.nextstep.baseball.domain.BaseballNumbers;
import com.nextstep.baseball.domain.BaseballStatus;
import com.nextstep.baseball.util.BaseballNumbersGanerator;
import com.nextstep.baseball.view.InputView;
import com.nextstep.baseball.view.PrintView;

import java.util.List;

public class BaseballGameController {

    public void run() {
        BaseballNumbers answers = BaseballNumbersGanerator.generateRandomNumbers();
        while (true) {
            try {
                List<Integer> numbers = InputView.inputNumbers();
                BaseballNumbers playerNumbers = new BaseballNumbers(numbers);
                BaseballStatus status = BaseballCounter.compareNumbers(playerNumbers, answers);
                PrintView.printBaseballStatus(status);
                if (isGameEnd(status)) {
                    PrintView.printGameEndMessage();
                    PrintView.printMenu();
                    int menu = InputView.inputMenu();
                    if (!restartGame(menu)) {
                        return;
                    }
                    answers = BaseballNumbersGanerator.generateRandomNumbers();
                }
            } catch (RuntimeException e) {
                PrintView.printErrorMessage(e.getMessage());
            }
        }
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
