package org.programmers.domain;

import java.util.ArrayList;
import java.util.List;

public class RandomNumber {

    //컴퓨터가 랜덤하게 수(3자리) 생성
    public static List<Integer> createRandomNumber() {
        List<Integer> numbers = new ArrayList<>();

        while (numbers.size() < 3) {
            int randomNumber = (int) (Math.random() * 9) + 1;
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }

//        for (Integer i : numbers) {
//            System.out.print(i);
//        }

        return numbers;
    }


}
