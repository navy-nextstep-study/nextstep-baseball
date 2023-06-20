package baseball.domain.ball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BallGenerator {

    private static final int BALL_COUNT = 3;
    private static final String BALL_COUNT_ERR_MSG = "볼의 개수는 " + BALL_COUNT + "이여야 합니다.";
    private static final String BALL_NUMBER_ERR_MSG = "각 수는 1 ~ 9 사이의 숫자만 입력이 가능합니다.";
    private static final String BALL_NUMBER_DUPLICATED_ERR_MSG = "각 수는 중복되지 않은 숫자여야 합니다.";

    public List<Ball> generateBalls() {

        List<Ball> computerBall = new ArrayList<>();
        List<Integer> randomBallNumbers = createRandomBall();

        for (int i = 0; i < BALL_COUNT; i++) {
            computerBall.add(new Ball(i + 1, randomBallNumbers.get(i)));
        }

        return computerBall;
    }

    private List<Integer> createRandomBall() {
        return Stream.generate(() -> (int) (Math.random() * 8) + 1)
                .distinct()
                .limit(BALL_COUNT)
                .collect(Collectors.toList());
    }

    public List<Ball> generateBalls(String inputValue) {
        try {
            validateBall(inputValue);
            return createBall(inputValue);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return Collections.emptyList();
        }
    }

    public void validateBall(String inputValue) {

        if (isNotCorrectBallCount(inputValue)) {
            throw new IllegalArgumentException(BALL_COUNT_ERR_MSG);
        }

        if (isNotDigitInputBallNumber(inputValue)) {
            throw new NumberFormatException(BALL_NUMBER_ERR_MSG);
        }

        if (isDuplicateBallNumber(inputValue)) {
            throw new IllegalArgumentException(BALL_NUMBER_DUPLICATED_ERR_MSG);
        }
    }

    private boolean isNotDigitInputBallNumber(String inputValue) {
        try {
            Integer.parseInt(inputValue);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isNotCorrectBallCount(String inputValue) {
        return inputValue.length() != BALL_COUNT;
    }

    private boolean isDuplicateBallNumber(String inputValue) {
        long distinctCount = Arrays.stream(inputValue.split(""))
                .distinct()
                .count();

        return inputValue.length() != distinctCount;
    }

    private List<Ball> createBall(String value) {
        ArrayList<Ball> balls = new ArrayList<>();
        String[] ballTokens = value.split("");

        for (int i = 0; i < BALL_COUNT; i++) {
            balls.add(new Ball(i + 1, Integer.parseInt(ballTokens[i])));
        }

        return balls;
    }
}
