package org.programmers.controller;

import org.programmers.domain.Numbers;
import org.programmers.domain.NumbersComparator;
import org.programmers.domain.RandomNumber;
import org.programmers.model.ResultDto;
import org.programmers.status.ProcessStatus;
import org.programmers.util.StringConverter;
import org.programmers.view.Console;

import java.util.List;

public class BaseballController {
    private static List<Integer> randomNumbers;
    private static final Console console = new Console();
    private static final NumbersComparator numberChecker = new NumbersComparator();
    private ProcessStatus processStatus = ProcessStatus.ONGOING;

    public void run() {
        randomNumbers = RandomNumber.createRandomNumber();
        do {
            console.printInputMessage();
            Numbers number = StringConverter.convertToNumbers(console.readNumber());
            ResultDto dto = numberChecker.checkNumber(number, randomNumbers);
            console.printResult(dto);
            checkResultAndRetry(dto);
        } while (processStatus.isOngoing());
    }

    public void checkResultAndRetry(ResultDto dto) {
        if (isFinish(dto)) {
            console.printFinishAndRestartMessage();
            int menu = console.readRetryMenu();
            if (menu == 2) {
                processStatus = ProcessStatus.FINISH;
            }
            randomNumbers = RandomNumber.createRandomNumber();
        }
    }

    private boolean isFinish(ResultDto dto) {
        return dto.getStrike() == 3;
    }

}
