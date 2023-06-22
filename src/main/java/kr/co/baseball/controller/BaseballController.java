package kr.co.baseball.controller;

import kr.co.baseball.domain.Computer;
import kr.co.baseball.domain.NumbersComparator;
import kr.co.baseball.domain.Player;
import kr.co.baseball.dto.ResponseDTO;
import kr.co.baseball.util.StringConverter;
import kr.co.baseball.view.InputView;
import kr.co.baseball.view.OutputView;

import java.util.function.Predicate;

public class BaseballController {
    private static final Predicate<ResponseDTO> NO_STRIKE = result -> result.getStrike() == 0;
    private static final Predicate<ResponseDTO> NO_BALL = result -> result.getBall() == 0;
    private static final Predicate<ResponseDTO> SUCCESS = result -> result.getStrike() == 3;
    private static final Predicate<ResponseDTO> ONE_MORE_STRIKES = result -> result.getStrike() > 0;
    private static final Predicate<ResponseDTO> ONE_MORE_BALLS = result -> result.getBall() > 0;
    private static final int RESTART = 1;
    private boolean isRun = true;
    private Computer computerNumber;

    public void runBaseball() throws IllegalArgumentException {
        NumbersComparator numbersComparator = new NumbersComparator();
        computerNumber = new Computer();

        do {
            try {
                Player player = new Player(StringConverter.convert(InputView.inputNumber()));
                ResponseDTO result = numbersComparator.compare(computerNumber, player);
                findOutputByResult(result);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (isRun);
    }

    private void findOutputByResult(ResponseDTO result) {
        if (NO_STRIKE.test(result) && NO_BALL.test(result)) {
            OutputView.outputNothing();
            return;
        }

        if (SUCCESS.test(result) && NO_BALL.test(result)) {
            OutputView.outputSuccess();
            restartOrEnd();
            return;
        }

        if (NO_STRIKE.test(result) && ONE_MORE_BALLS.test(result)) {
            OutputView.outputNoStrike(result);
            return;
        }

        if (ONE_MORE_STRIKES.test(result) && NO_BALL.test(result)) {
            OutputView.outputNoBall(result);
            return;
        }

        OutputView.outputResult(result);
    }

    private void restartOrEnd() {
        if (InputView.inputRestart() == RESTART) {
            computerNumber = new Computer();
            return;
        }

        isRun = false;
    }
}
