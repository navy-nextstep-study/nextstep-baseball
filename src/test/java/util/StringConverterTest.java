package util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.programmers.util.StringConverter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringConverterTest {


    @DisplayName("공백이 정상적으로 제거되면 성공")
    @ParameterizedTest
    @CsvSource(value = {"123   :123", "1     2 3:123"}, delimiter = ':')
    void 공백_제거_테스트(String input, String output) {
        assertThat(StringConverter.removeWhiteSpace(input)).isEqualTo(output);
    }

    @Test
    @DisplayName("입력된 수의 길이가 3인지 확인 - 성공 테스트")
    void 입력한_수의_길이가_3일때_성공() {
        String numbers = "123";
        assertThat(numbers.length()).isEqualTo(3);
    }

    @Test
    @DisplayName("입력된 수의 길이가 3인지 확인 - 실패 테스트")
    void 입력한_수의_길이가_3이_아닐때_실패() {
        String numbers = "1234";

        assertThatThrownBy(() -> StringConverter.check3Digits(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력한 수의 길이가 3이 아닙니다.");
    }


}
