package baseball.validation;

public class BallValidator {

    public static boolean validateNumberInRange(int number) {
        return number >= 1 && number <= 9;
    }
}
