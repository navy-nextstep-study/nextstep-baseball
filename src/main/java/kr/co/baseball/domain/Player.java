package kr.co.baseball.domain;

import java.util.List;

public class Player {
    private final Numbers numbers;

    public Player(List<Integer> numbers) {
        this.numbers = new Numbers(numbers);
    }

    public List<Integer> getNumbers() {
        return this.numbers.getNumbers();
    }

    public int get(int index) {
        return this.numbers.get(index);
    }
}
