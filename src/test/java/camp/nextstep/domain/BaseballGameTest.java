package camp.nextstep.domain;

import camp.nextstep.dto.BaseballGameResponse;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballGameTest {

    @Test
    void 숫자야구게임을_실행한다() {
        // given
        Numbers numbers = new Numbers(List.of(1, 2, 3));
        BaseballGame baseballGame = new BaseballGame(new Answer(numbers));

        // when
        BaseballGameResponse result = baseballGame.play(numbers);

        // then
        assertThat(result).isEqualTo(new BaseballGameResponse(3, 0));
    }
}
