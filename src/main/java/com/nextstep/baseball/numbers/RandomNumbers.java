package com.nextstep.baseball.numbers;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomNumbers {
    private final List<String> numbers;
    private final int RANDOM_NUM_START = 1;
    private final int RANDOM_NUM_END = 10;
    private final int RANDOM_NUM_LENGTH = 3;

    public RandomNumbers(){
        numbers = createRandomNum();
    }

    public RandomNumbers(String input){
        numbers = Arrays.asList(input.split(""));
    }

    private List<String> createRandomNum(){
        return new Random().ints(RANDOM_NUM_START,RANDOM_NUM_END)
                .distinct()
                .limit(RANDOM_NUM_LENGTH)
                .boxed()
                .map(String::valueOf)
                .collect(Collectors.toList());
    }

    public List<String> getNumbers() {
        return numbers;
    }
}
