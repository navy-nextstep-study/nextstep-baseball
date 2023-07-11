package baseball.validation;

public class BallValidator {

    public static boolean validateNumberInRange(int number) {
        return number >= 1 && number <= 9;
    }

    public static boolean validateIndexInRange(int index) {
        return index >= 1 && index <= 3;
    }
}
