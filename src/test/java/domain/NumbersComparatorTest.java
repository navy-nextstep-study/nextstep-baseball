package domain;

import kr.co.baseball.domain.Computer;
import kr.co.baseball.domain.NumbersComparator;
import kr.co.baseball.domain.Player;
import kr.co.baseball.dto.ResponseDTO;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumbersComparatorTest {

    @ParameterizedTest
    @MethodSource("컴퓨터_숫자와_플레이어_숫자를_비교한다")
    void 스트라이크와_볼이_N개_있다(List<Integer> computer, List<Integer> player, ResponseDTO expected) {
        //given
        NumbersComparator numbersComparator = new NumbersComparator();

        //when
        ResponseDTO actual = numbersComparator.compare(new Computer(computer), new Player(player));

        //then
        assertEquals(expected.getStrike(), actual.getStrike());
        assertEquals(expected.getBall(), actual.getBall());
    }

    private static Stream<Arguments> 컴퓨터_숫자와_플레이어_숫자를_비교한다() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3), List.of(1, 2, 3), new ResponseDTO(3, 0)),
                Arguments.of(List.of(1, 2, 3), List.of(7, 8, 1), new ResponseDTO(0, 1)),
                Arguments.of(List.of(1, 2, 3), List.of(7, 1, 2), new ResponseDTO(0, 2)),
                Arguments.of(List.of(1, 2, 3), List.of(3, 1, 2), new ResponseDTO(0, 3)),
                Arguments.of(List.of(1, 2, 3), List.of(1, 7, 8), new ResponseDTO(1, 0)),
                Arguments.of(List.of(1, 2, 3), List.of(1, 2, 7), new ResponseDTO(2, 0)),
                Arguments.of(List.of(1, 2, 3), List.of(7, 8, 9), new ResponseDTO(0, 0)),
                Arguments.of(List.of(1, 2, 3), List.of(3, 2, 7), new ResponseDTO(1, 1)),
                Arguments.of(List.of(1, 2, 3), List.of(3, 2, 1), new ResponseDTO(1, 2))
        );
    }
}
