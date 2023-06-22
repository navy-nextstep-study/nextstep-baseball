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


}
