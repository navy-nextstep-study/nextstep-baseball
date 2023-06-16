package domain;

import kr.co.baseball.domain.Numbers;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumbersExceptionTest {

    @Test
    @Disabled
    @DisplayName("숫자가 아닌 값을 포함했을 때,")
    void isNumber_정답을_맞추기_위해_1_부터_9로_이루어진_3자리_수_입력_FALSE() {
    }

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

    @Test
    @DisplayName("3자리 수가 아닌 값을 입력 했을 때, - IllegalArgumentException")
    void validateNumbersSize_정답을_맞추기_위해_1_부터_9로_이루어진_3자리_수_입력_Exception() {
        //given
        List<Integer> input1 = List.of(1, 2, 3, 7);
        List<Integer> input2 = List.of(1, 2);

        //when & then
        assertThatThrownBy(() -> new Numbers(input1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("3자리 수만 입력 가능합니다.");
        assertThatThrownBy(() -> new Numbers(input2))
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
}