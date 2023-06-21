package com.nextstep.baseball.io;

import com.nextstep.baseball.dto.GameResult;

import java.util.Scanner;

public class Console implements Input, Output {

    private final Scanner scanner = new Scanner(System.in);

    private Console() {}

    private static class ConsoleSingleton {
        private static final Console consoleInstance = new Console();
    }

    public static Console getInstance(){
        return ConsoleSingleton.consoleInstance;
    }

    @Override
    public String inputGameNum() {
        return scanner.nextLine();
    }

    @Override
    public String inputMenuNum() {
        return scanner.nextLine();
    }

    @Override
    public void outputInputMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    @Override
    public void outputResult(GameResult result) {
        if(result.getBallCount() != 0 && result.getStrikeCount() != 0){
            System.out.printf("%d볼 %d스트라이크%n", result.getBallCount(), result.getStrikeCount());
            return;
        }
        if(result.getBallCount() == 0 && result.getStrikeCount() != 0){
            System.out.printf("%d스트라이크%n", result.getStrikeCount());
            return;
        }
        if(result.getBallCount() != 0 && result.getStrikeCount() == 0){
            System.out.printf("%d볼%n", result.getBallCount());
            return;
        }

        System.out.println("Nothing");
    }

    @Override
    public void outputEndGame() {
        System.out.println("게임이 종료되었습니다.");
    }

    @Override
    public void outputMenuSelect() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료.");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
    }
}
