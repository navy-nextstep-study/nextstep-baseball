package com.nextstep.baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void replace(){
        String actual = "abc".replace("b","d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void 문자열_나누기(){
        String str1 = "1,2";
        String[] strArr1 = str1.split(",");

        String str2 = "1";
        String[] strArr2 = str2.split(",");

        assertThat(strArr1).contains("1","2");
        assertThat(strArr2).containsExactly("1");
    }

    @Test
    void 문자열_자르기(){
        String str = "(1,2)";
        String answer = str.substring(1,4);

        assertThat(answer).isEqualTo("1,2");
    }

    @Test
    @DisplayName("특정 위치의 문자를 가져올 때 위치 값을 벗어나면 예외가 발생한다.")
    void 문자_가져오기(){
        String str = "abc";
        assertThatThrownBy(() -> str.charAt(3))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }
}
