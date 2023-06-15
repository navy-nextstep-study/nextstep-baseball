package camp.nextstep.domain;

import camp.nextstep.dto.BaseballGameResponse;

import java.util.List;

public class BaseballGame {

    private Answer answer;

    public BaseballGame(NumberCreationStrategy strategy) {
        this(new Answer(strategy));
    }

    public BaseballGame(Answer answer) {
        this.answer = answer;
    }

    public BaseballGameResponse play(List<Integer> input) {
        return answer.compare(input);
    }
}
