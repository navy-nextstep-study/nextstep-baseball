package camp.nextstep.view;

import camp.nextstep.domain.Numbers;
import camp.nextstep.util.StringSplitter;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static int NEW_GAME = 1;
    public static int END_GAME = 2;

    public static Numbers inputNumbers() {
        System.out.print("숫자를 입력해 주세요 : ");
        return new Numbers(StringSplitter.splitToList(SCANNER.next()));
    }

    public static int inputNextGameWhether() {
        System.out.printf("게임을 새로 시작하려면 %d, 종료하려면 %d를 입력하세요.%n", NEW_GAME, END_GAME);
        return SCANNER.nextInt();
    }
}
