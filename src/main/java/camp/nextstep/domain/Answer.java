package camp.nextstep.domain;

import camp.nextstep.dto.BaseballGameResponse;

public class Answer {

    private final Numbers numbers;

    public Answer(NumberCreationStrategy strategy) {
        this(strategy.create());
    }

    public Answer(Numbers numbers) {
        this.numbers = numbers;
    }

    public BaseballGameResponse compare(Numbers input) {
        int strike = 0;
        int ball = 0;
        for (int answerIndex = 0; answerIndex < numbers.size(); answerIndex++) {
            int[] result = numbers.compareTo(input, answerIndex);

            strike += result[0];
            ball += result[1];
        }
        return new BaseballGameResponse(strike, ball);
    }
}
