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
    private ProcessStatus processStatus = ProcessStatus.ONGOING;
    private static final Console console = new Console();
    private static final NumbersComparator numberChecker = new NumbersComparator();
    private static List<Integer> randomNumbers;

    public void run() {
        randomNumbers = RandomNumber.createRandomNumber();
        do {
            console.printInputMessage();

            Numbers number = StringConverter.convertToNumbers(console.readNumber());

            ResultDto dto = numberChecker.checkNumber(number, randomNumbers);

            console.printResult(dto);

            checkResultAndRetry(dto);

        } while (processStatus.equals(ProcessStatus.ONGOING));
    }

    public void checkResultAndRetry(ResultDto dto) {
        if (dto.is3Strike()) {
            console.printFinishAndRestartMessage();
            int menu = console.readRetryMenu();
            if (menu == 2) {
                processStatus = ProcessStatus.FINISH;
            }
            randomNumbers = RandomNumber.createRandomNumber();
        }
    }


}
