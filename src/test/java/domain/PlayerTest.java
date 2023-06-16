package domain;

import kr.co.baseball.domain.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {

    @Test
    @DisplayName("정상적인 값을 입력 했을 떄, - SUCCESS")
    void 정답을_맞추기_위해_1_부터_9로_이루어진_3자리_수_입력() {
        //given
        List<Integer> input1 = List.of(1, 2, 3);
        List<Integer> input2 = List.of(7, 8, 9);
        List<Integer> input3 = List.of(3, 7, 1);

        //when
        Player player1 = new Player(input1);
        Player player2 = new Player(input2);
        Player player3 = new Player(input3);

        //then
        assertEquals(input1, player1.getNumbers());
        assertEquals(input2, player2.getNumbers());
        assertEquals(input3, player3.getNumbers());
    }
}
