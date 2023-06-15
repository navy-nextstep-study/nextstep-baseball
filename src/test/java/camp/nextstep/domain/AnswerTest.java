package camp.nextstep.domain;

import camp.nextstep.dto.BaseballGameResponse;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class AnswerTest {

    @ParameterizedTest(name = "[{index}] 입력 : {0}, 정답 : {1}")
    @MethodSource
    void 정답과_입력값을_비교한다(Numbers numbers, Numbers input, BaseballGameResponse expected) {
        // given
        Answer answer = new Answer(numbers);

        // when
        BaseballGameResponse result = answer.compare(input);

        // then
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> 정답과_입력값을_비교한다() {
        return Stream.of(
                Arguments.of(new Numbers(List.of(1, 2, 3)), new Numbers(List.of(3, 4, 5)),
                        new BaseballGameResponse(0, 1)),
                Arguments.of(new Numbers(List.of(1, 2, 3)), new Numbers(List.of(4, 5, 3)),
                        new BaseballGameResponse(1, 0)),
                Arguments.of(new Numbers(List.of(1, 2, 3)), new Numbers(List.of(2, 5, 3)),
                        new BaseballGameResponse(1, 1))
        );
    }
}
