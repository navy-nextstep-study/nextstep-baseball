package org.programmers.util;

import org.programmers.domain.Numbers;

import java.util.List;
import java.util.stream.Collectors;

public class StringConverter {
    public static Numbers convertToNumbers(String number) {
        number = removeWhiteSpace(number);

        check3Digits(number);

        List<Integer> list = number
                .chars()
                .mapToObj(Character::getNumericValue)
                .collect(Collectors.toList());
        return new Numbers(list);
    }

    public static String removeWhiteSpace(String number) {
        return number.replaceAll("\\s+", "");
    }

    public static void check3Digits(String num) {
        if (num.length() != 3) {
            throw new IllegalArgumentException("입력한 수의 길이가 3이 아닙니다.");
        }
    }
}
