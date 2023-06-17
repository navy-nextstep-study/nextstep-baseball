package com.nextstep.baseball;

import com.nextstep.baseball.numbers.BaseballNumbers;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

public class NumbersTest {
    @Test
    void 입력한_수가_정상적인_리스트로_변환되어_나오는지_확인(){
        // given
        String inputNumber = "123";

        // when
        List<String> numbers =  new BaseballNumbers(inputNumber).getNumbers();

        // then
        Assertions.assertThat(numbers).isEqualTo(List.of("1","2","3"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"12#","1a2","ㅁㄴ3"})
    void 입력값이_숫자가_아닐때_예외가_발생된다(String inputNumber){
        // when && then
        Assertions.assertThatThrownBy(() -> new BaseballNumbers(inputNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자가 아닌 값을 입력하셨습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1234","12","3"})
    void 입력한_수의_길이가_3이_아닐때_예외가_빨생된다(String inputNumber){
        // when && then
        Assertions.assertThatThrownBy(() -> new BaseballNumbers(inputNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력하신 숫자의 개수가 3개가 아닙니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"122","333","171"})
    void 입력한_수에_동일한_숫자가_있을때_예외가_발생한다(String inputNumber){
        // when && then
        Assertions.assertThatThrownBy(() -> new BaseballNumbers(inputNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("동일한 숫자를 입력하셨습니다.");
    }
}
