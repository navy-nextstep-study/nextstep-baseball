package com.nextstep.baseball.numbers;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomNumbers {
    private final List<String> numbers;

    public RandomNumbers(){
        numbers = createRandomNum();
    }

    private List<String> createRandomNum(){
        return new Random().ints(1,10)
                .distinct()
                .limit(3)
                .boxed()
                .map(String::valueOf)
                .collect(Collectors.toList());
    }

    public List<String> getNumbers() {
        return numbers;
    }
}
