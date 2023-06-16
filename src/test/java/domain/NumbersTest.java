package domain;

import kr.co.baseball.domain.Numbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumbersTest {

    @Test
    @DisplayName("정상적인 값을 입력 했을 떄, - SUCCESS")
    void 정답을_맞추기_위해_1_부터_9로_이루어진_3자리_수_입력() {
        //given
        List<Integer> input1 = List.of(1, 2, 3);
        List<Integer> input2 = List.of(7, 8, 9);
        List<Integer> input3 = List.of(3, 7, 1);

        //when
        Numbers numbers1 = new Numbers(input1);
        Numbers numbers2 = new Numbers(input2);
        Numbers numbers3 = new Numbers(input3);

        //then
        assertEquals(input1, numbers1.getNumbers());
        assertEquals(input2, numbers2.getNumbers());
        assertEquals(input3, numbers3.getNumbers());
    }
}
