package domain;

import kr.co.baseball.domain.NumbersCompare;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumbersCompareTest {

    @ParameterizedTest
    @MethodSource("컴퓨터_숫자와_플레이어_숫자를_비교한다")
    void 스트라이크는_없고_볼이_N개_있다(List<Integer> computer, List<Integer> player, int[] expected) {
        //given
        NumbersCompare numbersCompare = new NumbersCompare();

        //when
        int[] actual = numbersCompare.numbersCompare(computer, player);

        //then
        assertEquals(expected[0], actual[0]);
        assertEquals(expected[1], actual[1]);
    }

    private static Stream<Arguments> 컴퓨터_숫자와_플레이어_숫자를_비교한다() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3), List.of(1, 2, 3), new int[]{3, 0}),
                Arguments.of(List.of(1, 2, 3), List.of(7, 8, 1), new int[]{0, 1}),
                Arguments.of(List.of(1, 2, 3), List.of(7, 1, 2), new int[]{0, 2}),
                Arguments.of(List.of(1, 2, 3), List.of(3, 1, 2), new int[]{0, 3}),
                Arguments.of(List.of(1, 2, 3), List.of(1, 7, 8), new int[]{1, 0}),
                Arguments.of(List.of(1, 2, 3), List.of(1, 2, 7), new int[]{2, 0}),
                Arguments.of(List.of(1, 2, 3), List.of(7, 8, 9), new int[]{0, 0}),
                Arguments.of(List.of(1, 2, 3), List.of(3, 2, 7), new int[]{1, 1}),
                Arguments.of(List.of(1, 2, 3), List.of(3, 2, 1), new int[]{1, 2})
        );
    }
}
