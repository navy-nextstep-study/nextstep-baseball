package domain;

import kr.co.baseball.domain.Numbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumbersExceptionTest {

    @Test
    @DisplayName("0을 포함했을 때, - IllegalArgumentException")
    void validateHasZero_정답을_맞추기_위해_1_부터_9로_이루어진_3자리_수_입력_Exception() {
        //given
        List<Integer> input = List.of(1, 2, 0);

        // when & then
        assertThatThrownBy(() -> new Numbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("0을 포함할 수 없습니다.");
    }

    @ParameterizedTest
    @MethodSource("세자리_수가_아닌_값을_입력_한다")
    @DisplayName("3자리 수가 아닌 값을 입력 했을 때, - IllegalArgumentException")
    void validateNumbersSize_정답을_맞추기_위해_1_부터_9로_이루어진_3자리_수_입력_Exception(List<Integer> input) {
        //given & when & then
        assertThatThrownBy(() -> new Numbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("3자리 수만 입력 가능합니다.");
    }

    @Test
    @DisplayName("중복된 값을 입력 했을 때, - IllegalArgumentException")
    void validateDuplicatedNumbers_정답을_맞추기_위해_1_부터_9로_이루어진_3자리_수_입력_Exception() {
        //given
        List<Integer> input = List.of(1, 2, 2);

        //when & then
        assertThatThrownBy(() -> new Numbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 값은 입력할 수 없습니다.");
    }

    @Test
    @DisplayName("1~9 범위를 벗어난 값을 입력했을 때, - IllegalArgumentException")
    void _정답을_맞추기_위해_1_부터_9로_이루어진_3자리_수_입력_Exception() {
        //given
        List<Integer> input = List.of(10, -1, 7);

        //when & then
        assertThatThrownBy(() -> new Numbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1~9 범위의 숫자만 입력 가능합니다.");
    }

    private static Stream<Arguments> 세자리_수가_아닌_값을_입력_한다() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 7)),
                Arguments.of(List.of(1, 2))
        );
    }
}
