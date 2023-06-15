package camp.nextstep.domain;

import camp.nextstep.dto.BaseballGameResponse;

public class BaseballGame {

    private Answer answer;

    public BaseballGame(NumberCreationStrategy strategy) {
        this(new Answer(strategy));
    }

    public BaseballGame(Answer answer) {
        this.answer = answer;
    }

    public BaseballGameResponse play(Numbers input) {
        return answer.compare(input);
    }
}
