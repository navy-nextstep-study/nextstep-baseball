package baseball;

import java.util.Objects;

public class BallNumber {

    int number;

    public BallNumber(String number) {
        validateNumber(number);
        this.number = Integer.parseInt(number);
    }

    private void validateNumber(String number) {
        validateIsDigit(number);
        validateIsRange(number);
    }

    private void validateIsDigit(String number) {
        if (!Character.isDigit(number.charAt(0)))
            throw new IllegalArgumentException("숫자만 입력이 가능합니다.");
    }

    private void validateIsRange(String number) {
        int convertNumber = Integer.parseInt(number);
        if (convertNumber < 1 || convertNumber > 9) {
            throw new IllegalArgumentException("숫자의 범위는 1 ~ 9 사이여야 합니다.");
        }
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
