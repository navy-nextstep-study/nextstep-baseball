package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.programmers.domain.RandomNumber;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class RandomNumberTest {
    private List<Integer> randomNumberList;
    public static final int NUMBERS_SIZE = 3;

    @BeforeEach
    void 랜덤수_생성() {
        randomNumberList = RandomNumber.createRandomNumber();
    }

    @DisplayName("랜덤 수 3개 생성 후 중복 확인")
    @Test
    void 랜덤수_중복_테스트() {
        assertDoesNotThrow(() -> RandomNumber.validateRandomNumberDuplication(randomNumberList));
    }

    @DisplayName("랜덤 수 3개 생성 후 범위 확인 -  실패 테스트")
    @Test
    void 랜덤수_0_9_범위_테스트() {
        assertDoesNotThrow(() -> RandomNumber.validateRange1To9(randomNumberList));
    }

    @DisplayName("랜덤 수 사이즈 3 확인")
    @Test
    void 랜덤수_사이즈가_3_확인_테스트() {
        assertThat(randomNumberList.size()).isEqualTo(NUMBERS_SIZE);
    }

}
