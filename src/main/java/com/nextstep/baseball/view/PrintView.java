package com.nextstep.baseball.view;

import com.nextstep.baseball.domain.BaseballStatus;

public class PrintView {

    public static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public static void printBaseballStatus(BaseballStatus baseballStatus) {
        StringBuilder builder = new StringBuilder();
        if (baseballStatus.getBalls() != 0) {
            builder.append(baseballStatus.getBalls());
            builder.append("볼 ");
        }
        if (baseballStatus.getStrikes() != 0) {
            builder.append(baseballStatus.getStrikes());
            builder.append("스트라이크 ");
        }
        System.out.println(builder);
    }

    public static void printGameEndMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void printMenu() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
