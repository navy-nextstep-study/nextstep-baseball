package camp.nextstep.domain;

import camp.nextstep.dto.BaseballGameResponse;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class AnswerTest {

    @ParameterizedTest
    @MethodSource
    void 정답과_입력값을_비교한다(List<Integer> numbers, List<Integer> input, int[] expected) {
        // given
        Answer answer = new Answer(numbers);

        // when
        BaseballGameResponse result = answer.compare(input);

        // then
        assertThat(result.getStrike()).isEqualTo(expected[0]);
        assertThat(result.getBall()).isEqualTo(expected[1]);
    }

    private static Stream<Arguments> 정답과_입력값을_비교한다() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3), List.of(3, 4, 5), new int[]{0, 1}),
                Arguments.of(List.of(1, 2, 3), List.of(4, 5, 3), new int[]{1, 0}),
                Arguments.of(List.of(1, 2, 3), List.of(2, 5, 3), new int[]{1, 1})
        );
    }
}
