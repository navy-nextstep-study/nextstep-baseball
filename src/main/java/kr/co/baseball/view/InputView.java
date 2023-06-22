package kr.co.baseball.view;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Scanner;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static String inputNumber() {
        System.out.print("숫자를 입력해주세요. : ");

        return SCANNER.nextLine();
    }

    public static int inputRestart() {
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. : ");
        final int input = SCANNER.nextInt();
        SCANNER.nextLine();

        return input;
    }
}
