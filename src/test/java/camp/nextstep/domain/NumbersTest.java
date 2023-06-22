package camp.nextstep.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumbersTest {

    @Test
    void 입력수가_3자리가_아니면_예외가_발생한다() {
        // given & when & then
        assertThatThrownBy(() -> new Numbers(List.of(1, 2, 3, 4)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력한 숫자는 3자리가 되어야 합니다.");
    }

    @Test
    void 정답번호와_입력숫자를_비교한다() {
        // given
        Numbers numbers = new Numbers(List.of(1, 2, 3));
        Numbers input = new Numbers(List.of(3, 2, 1));

        // when
        int[] result = numbers.compareTo(input, 2);

        // then
        assertThat(result[1]).isEqualTo(1);
    }

    @Test
    void 숫자들의_사이즈를_반환한다() {
        // given
        Numbers numbers = new Numbers(List.of(1, 2, 3));

        // when
        int result = numbers.size();

        // then
        assertThat(result).isEqualTo(3);
    }

    @Test
    void 숫자들에서_인덱스를_통해_숫자를_반환한다() {
        // given
        Numbers numbers = new Numbers(List.of(1, 2, 3));

        // when
        int result = numbers.get(2);

        // then
        assertThat(result).isEqualTo(3);
    }
}
