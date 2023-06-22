package domain;

import kr.co.baseball.domain.Computer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComputerTest {

    Computer computer1;
    Computer computer2;
    Computer computer3;

    @BeforeEach
    void setUp() {
        //given & when
        computer1 = new Computer();
        computer2 = new Computer();
        computer3 = new Computer();
    }

    @Test
    @DisplayName("임의의 수의 자리수가 3인 지, - SUCCESS")
    void 임의의_수의_자리수가_3인지() {
        //then
        assertEquals(3, computer1.size());
        assertEquals(3, computer2.size());
        assertEquals(3, computer3.size());
    }

    @Test
    @DisplayName("임의의 수가 0을 포함하지 않는 지, - SUCCESS")
    void 임의의_수가_0을_포함하지_않는지() {
        //then
        assertThat(computer1.contains(0)).isFalse();
        assertThat(computer2.contains(0)).isFalse();
        assertThat(computer3.contains(0)).isFalse();
    }

    @Test
    @DisplayName("임의의 수가 중복된 값을 포함하지 않는 지, - SUCCESS")
    void 임의의_수가_중복된_값을_포함하지_않는_지() {
        //given & when
        int size1 = (int) computer1.getNumbers()
                .stream()
                .distinct()
                .count();
        int size2 = (int) computer2.getNumbers()
                .stream()
                .distinct()
                .count();
        int size3 = (int) computer3.getNumbers()
                .stream()
                .distinct()
                .count();

        //then
        assertEquals(3, size1);
        assertEquals(3, size2);
        assertEquals(3, size3);
    }
}
