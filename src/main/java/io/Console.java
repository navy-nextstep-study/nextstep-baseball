package io;

import baseball.domain.game.PlayResult;

import java.util.Scanner;

public class Console implements Input, Output {

    private static final Scanner SCANNER = new Scanner(System.in);

    @Override
    public String inputUserBalls() {
        return SCANNER.nextLine();
    }

    @Override
    public String inputRetryNumber() {
        return SCANNER.nextLine();
    }

    @Override
    public void outputRequestNumberMsg() {
        System.out.print("숫자를 입력해 주세요 : ");
    }

    @Override
    public void outputGameResult(PlayResult result) {
        if (!result.isError()) {
            System.out.println(result);
        }
    }

    @Override
    public void outputRequestRetryMsg() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    @Override
    public void outputCorrectAnswerMsg() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
