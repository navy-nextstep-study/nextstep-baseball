package org.programmers.view;

import org.programmers.model.Result;

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
    public void printResult(Result result) {
        System.out.println();//todo : enum 개발하고 여기 다시 정리
    }

    @Override
    public void printFinishMessage() {
        System.out.println(GAME_FINISH_MESSAGE);
    }

    @Override
    public void printRetryMessage() {
        System.out.println(GAME_RETRY_MESSAGE);
    }

    //입력 관련 함수

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
