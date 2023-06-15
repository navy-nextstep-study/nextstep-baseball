package camp.nextstep.view;

import camp.nextstep.controller.BaseballGameController;
import camp.nextstep.dto.BaseballGameResponse;

public class OutputView {

    public static void outputPlayResult(BaseballGameResponse response) {
        if (response.getBall() == 0 && response.getStrike() == 0) {
            System.out.println("낫싱");
            return;
        }

        if (response.getBall() == 0) {
            System.out.printf("%d스트라이크%n", response.getStrike());
            return;
        }

        if (response.getStrike() == 0) {
            System.out.printf("%d볼%n", response.getBall());
            return;
        }

        System.out.printf("%d볼 %d스트라이크%n", response.getBall(), response.getStrike());
    }

    public static void outputEnd() {
        System.out.printf("%d개의 숫자를 모두 맞히셨습니다! 게임 종료%n", BaseballGameController.CORRECTION);
    }
}
