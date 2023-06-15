package camp.nextstep.controller;

import camp.nextstep.domain.BaseballGame;
import camp.nextstep.domain.Numbers;
import camp.nextstep.domain.RandomNumberCreation;
import camp.nextstep.dto.BaseballGameResponse;
import camp.nextstep.view.InputView;
import camp.nextstep.view.OutputView;

public class BaseballGameController {

    public static int CORRECTION = 3;

    public void run() {
        int end = 1;
        do {
            BaseballGame baseballGame = new BaseballGame(new RandomNumberCreation());
            Numbers numbers = InputView.inputNumbers();
            BaseballGameResponse response = baseballGame.play(numbers);
            OutputView.outputPlayResult(response);

            if (isCorrect(response)) {
                OutputView.outputEnd();
                end = InputView.inputNextGameWhether();
            }
        } while (end != InputView.END_GAME);

    }

    private boolean isCorrect(BaseballGameResponse response) {
        return response.getStrike() == CORRECTION;
    }
}
