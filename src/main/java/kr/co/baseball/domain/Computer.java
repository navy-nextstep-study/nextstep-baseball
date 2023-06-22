package kr.co.baseball.domain;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class Computer {

    private final Numbers numbers;

    public Computer() {
        final ThreadLocalRandom random = ThreadLocalRandom.current();
        final List<Integer> numbers = random.ints(Numbers.RANGE_MIN, Numbers.RANGE_MAX + 1)
                .distinct()
                .limit(Numbers.NUMBERS_SIZE)
                .boxed()
                .collect(Collectors.toList());

        this.numbers = new Numbers(numbers);
    }

    public Computer(List<Integer> numbers) {
        this.numbers = new Numbers(numbers);
    }

    public List<Integer> getNumbers() {
        return this.numbers.getNumbers();
    }

    public int get(int index) {
        return this.numbers.get(index);
    }

    public int size() {
        return this.numbers.getNumbers().size();
    }

    public boolean contains(int value) {
        return this.numbers.contains(value);
    }
}
