package domain;

import kr.co.baseball.domain.Numbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumbersTest {

    @ParameterizedTest
    @MethodSource("정상적인_숫자값을_입력한다")
    @DisplayName("1부터 9인 정상적인 값을 입력 했을 때, - SUCCESS")
    void 정상적인_숫자값을_입력한다(List<Integer> input) {
        //given & when
        Numbers numbers = new Numbers(input);

        //then
        assertEquals(input, numbers.getNumbers());
    }

    private static Stream<Arguments> 정상적인_숫자값을_입력한다() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3)),
                Arguments.of(List.of(7, 8, 9)),
                Arguments.of(List.of(3, 7, 1))
        );
    }
}
