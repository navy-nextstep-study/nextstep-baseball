package domain;

import kr.co.baseball.domain.PlayerNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerNumbersTest {

    @Test
    @DisplayName("정상적인 값을 입력 했을 떄, - SUCCESS")
    void 정답을_맞추기_위해_1_부터_9로_이루어진_3자리_수_입력() {
        //given
        List<Integer> input1 = List.of(1, 2, 3);
        List<Integer> input2 = List.of(7, 8, 9);
        List<Integer> input3 = List.of(3, 7, 1);

        //when
        PlayerNumbers playerNumbers1 = new PlayerNumbers(input1);
        PlayerNumbers playerNumbers2 = new PlayerNumbers(input2);
        PlayerNumbers playerNumbers3 = new PlayerNumbers(input3);

        //then
        assertEquals(input1, playerNumbers1.getPlayerNumbers());
        assertEquals(input2, playerNumbers2.getPlayerNumbers());
        assertEquals(input3, playerNumbers3.getPlayerNumbers());
    }
}
