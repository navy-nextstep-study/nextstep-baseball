package org.programmers.view;

import org.programmers.model.ResultDto;

import java.util.Scanner;

public class Console implements Input, Output {
    private static final String INPUT_MESSAGE = "숫자를 입력해 주세요 :";
    private static final String GAME_FINISH_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String GAME_RETRY_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public void printInputMessage() {
        System.out.println(INPUT_MESSAGE);
    }

    @Override
    public void printResult(ResultDto result) {
        if (result.getBall() > 0 && result.getStrike() > 0) {
            System.out.printf("%d볼 %d스트라이크\n", result.getBall(), result.getStrike());
            return;
        }

        if (result.getStrike() == 0 && result.getBall() == 0) {
            System.out.println("낫싱");
            return;
        }

        if (result.getStrike() == 0) {
            System.out.printf("%d볼\n", result.getBall());
            return;
        }

        if (result.getBall() == 0) {
            System.out.printf("%d스트라이크\n", result.getStrike());
        }
    }

    @Override
    public void printFinishAndRestartMessage() {
        System.out.println(GAME_FINISH_MESSAGE);
        System.out.println(GAME_RETRY_MESSAGE);
    }


    @Override
    public String readNumber() {
        return scanner.nextLine();
    }

    @Override
    public int readRetryMenu() {
        String str = scanner.nextLine();
        return Integer.parseInt(str);
    }
}
