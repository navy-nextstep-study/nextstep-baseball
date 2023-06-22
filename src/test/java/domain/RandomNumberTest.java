package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.programmers.domain.RandomNumber;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class RandomNumberTest {
    public static final int NUMBERS_SIZE = 3;
    private static final int MAX_VALUE = 9;
    private static final int MIN_VALUE = 1;
    private List<Integer> randomNumberList;

    //난수 테스트를 위한 함수
    private static void validateRandomNumberDuplication(List<Integer> numbers) {
        boolean hasDuplicate = numbers
                .stream()
                .distinct()
                .count() != numbers.size();
        if (hasDuplicate) {
            throw new IllegalArgumentException("중복된 수가 존재합니다.");
        }
    }

    private static void validateRange1To9(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < MIN_VALUE || number > MAX_VALUE) {
                throw new IllegalArgumentException("1부터 9까지 범위의 수로 이루어져 있지 않습니다.");
            }
        }
    }

    @BeforeEach
    void 랜덤수_생성() {
        randomNumberList = RandomNumber.createRandomNumber();
    }

    @DisplayName("랜덤 수 3개 생성 후 중복 확인")
    @Test
    void 랜덤수_중복_테스트() {
        assertDoesNotThrow(() -> RandomNumberTest.validateRandomNumberDuplication(randomNumberList));
    }

    @DisplayName("랜덤 수 3개 생성 후 범위 확인 -  실패 테스트")
    @Test
    void 랜덤수_0_9_범위_테스트() {
        assertDoesNotThrow(() -> RandomNumberTest.validateRange1To9(randomNumberList));
    }

    @DisplayName("랜덤 수 사이즈 3 확인")
    @Test
    void 랜덤수_사이즈가_3_확인_테스트() {
        assertThat(randomNumberList.size()).isEqualTo(NUMBERS_SIZE);
    }

}
