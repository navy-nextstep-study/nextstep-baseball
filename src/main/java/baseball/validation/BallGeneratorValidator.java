package baseball.validation;

import baseball.domain.ball.BallGenerator;

import java.util.Arrays;

public class BallGeneratorValidator {

    private static final String BALL_COUNT_ERR_MSG = "볼의 개수는 " + BallGenerator.BALL_COUNT + "개 여야 합니다.";
    private static final String BALL_NUMBER_ERR_MSG = "각 수는 1 ~ 9 사이의 숫자만 입력이 가능합니다.";
    private static final String BALL_NUMBER_DUPLICATED_ERR_MSG = "각 수는 중복되지 않은 숫자여야 합니다.";

    public static void validateBall(String inputValue) {
        validBallCount(inputValue);
        validDigitInputBallNumber(inputValue);
        validDuplicateBallNumber(inputValue);
    }

    private static void validBallCount(String inputValue) {
        if (inputValue.length() != BallGenerator.BALL_COUNT) {
            throw new IllegalArgumentException(BALL_COUNT_ERR_MSG);
        }
    }

    private static void validDigitInputBallNumber(String inputValue) {
        try {
            Integer.parseInt(inputValue);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(BALL_NUMBER_ERR_MSG);
        }
    }

    private static void validDuplicateBallNumber(String inputValue) {
        long distinctCount = Arrays.stream(inputValue.split("")).distinct().count();

        if (inputValue.length() != distinctCount) {
            throw new IllegalArgumentException(BALL_NUMBER_DUPLICATED_ERR_MSG);
        }
    }
}
