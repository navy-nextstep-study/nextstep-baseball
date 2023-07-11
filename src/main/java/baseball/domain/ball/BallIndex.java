package baseball.domain.ball;

import java.util.Objects;

public class BallIndex {

    private static final int MIN_INDEX_RANGE = 0;
    private static final int MAX_INDEX_RANGE = 3;
    private static final String ERR_MSG = "index의 범위는 1 ~ 3 이여야 합니다.";
    private final int index;

    public BallIndex(int index) {
        validateIndex(index);
        this.index = index;
    }

    private void validateIndex(int index) {
        validateInRange(index);
    }

    private void validateInRange(int index) {
        if (isOutOfBound(index)) {
            throw new IllegalArgumentException(ERR_MSG);
        }
    }

    private boolean isOutOfBound(int index) {
        return index <= MIN_INDEX_RANGE || index > MAX_INDEX_RANGE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BallIndex ballIndex1 = (BallIndex) o;
        return index == ballIndex1.index;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index);
    }
}
