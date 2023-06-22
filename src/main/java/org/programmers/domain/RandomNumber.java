package org.programmers.domain;

import java.util.ArrayList;
import java.util.List;

public class RandomNumber {
    private static final int MAX_VALUE = 9;
    private static final int MIN_VALUE = 1;
    private static final int NUMBER_SIZE = 3;


    //컴퓨터가 랜덤하게 수(3자리) 생성
    public static List<Integer> createRandomNumber() {
        List<Integer> numbers = new ArrayList<>();

        while (checkNumbersSize(numbers)) {
            int randomNumber = (int) (Math.random() * MAX_VALUE) + MIN_VALUE;
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }

    private static boolean checkNumbersSize(List<Integer> numbers) {
        return numbers.size() < NUMBER_SIZE;
    }


    //테스트를 위한 validate 함수

    public static void validateRandomNumberDuplication(List<Integer> numbers) {
        boolean hasDuplicate = numbers
                .stream()
                .distinct()
                .count() != numbers.size();
        if (hasDuplicate) {
            throw new IllegalArgumentException("중복된 수가 존재합니다.");
        }
    }

    public static void validateRange1To9(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < MIN_VALUE || number > MAX_VALUE) {
                throw new IllegalArgumentException("1부터 9까지 범위의 수로 이루어져 있지 않습니다.");
            }
        }
    }


}
