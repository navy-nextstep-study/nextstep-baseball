package com.nextstep.baseball.view;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static List<Integer> inputNumbers() {
        System.out.print("숫자를 입력해 주세요 : ");
        int numbers = SCANNER.nextInt();
        return integerToList(numbers);
    }

    private static List<Integer> integerToList(int number) {
        return Stream.of(String.valueOf(number).split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int inputMenu() {
        return SCANNER.nextInt();
    }
}
