package kr.co.baseball.controller;

import kr.co.baseball.domain.Computer;
import kr.co.baseball.domain.NumbersCompared;
import kr.co.baseball.domain.Player;
import kr.co.baseball.util.StringConverter;
import kr.co.baseball.view.InputView;
import kr.co.baseball.view.OutputView;

import java.util.List;

public class BaseballController {
    private static boolean isRun = true;
    private static List<Integer> computerNumber;

    public void runBaseball() throws IllegalArgumentException {
        NumbersCompared numbersCompared = new NumbersCompared();
        computerNumber = new Computer().getNumbers();

        do {
            try {
                Player player = new Player(StringConverter.convert(InputView.inputNumber()));
                int[] result = numbersCompared.compare(computerNumber, player.getNumbers());
                findOutputByResult(result);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (isRun);
    }

    private void findOutputByResult(int[] result) {
        if (result[0] == 0 && result[1] == 0) {
            OutputView.outputNothing();
            return;
        }

        if (result[0] == 3 && result[1] == 0) {
            OutputView.outputSuccess();
            restartOrEnd();
            return;
        }

        if (result[0] == 0 && result[1] > 0) {
            OutputView.outputNoStrike(result);
            return;
        }

        if (result[0] > 0 && result[1] == 0) {
            OutputView.outputNoBall(result);
            return;
        }

        OutputView.outputResult(result);
    }

    private void restartOrEnd() {
        if (InputView.inputRestart() == 1) {
            computerNumber = new Computer().getNumbers();
            return;
        }

        isRun = false;
    }
}
