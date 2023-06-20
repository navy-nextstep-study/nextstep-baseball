package baseball.domain.ball;

import java.util.Objects;

public class BallNumber {
    private static final int MIN_NUMBER_RANGE = 1;
    private static final int MAX_NUMBER_RANGE = 9;
    private final int number;
    private static final String ERRMSG = "1 ~ 9 사이의 숫자만 입력이 가능합니다.";

    public BallNumber(String number) {
        validateNumber(number);
        this.number = Integer.parseInt(number);
    }

    private void validateNumber(String number) {
        validateIsDigit(number);
        validateInRange(number);
    }

    private void validateIsDigit(String number) {
        if (!Character.isDigit(number.charAt(0))) {
            throw new IllegalArgumentException(ERRMSG);
        }
    }

    private void validateInRange(String number) {
        int convertNumber = Integer.parseInt(number);
        if (isOutOfBound(convertNumber)) {
            throw new IllegalArgumentException(ERRMSG);
        }
    }

    private boolean isOutOfBound(int convertNumber) {
        return convertNumber < MIN_NUMBER_RANGE || convertNumber > MAX_NUMBER_RANGE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BallNumber that = (BallNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
