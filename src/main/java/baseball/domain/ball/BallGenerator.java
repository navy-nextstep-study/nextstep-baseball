package baseball.domain.ball;

import baseball.validation.BallGeneratorValidator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BallGenerator {

    public static final int BALL_COUNT = 3;

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
            BallGeneratorValidator.validateBall(inputValue);
            return createInputBall(inputValue);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return Collections.emptyList();
        }
    }

    private List<Ball> createInputBall(String value) {
        ArrayList<Ball> balls = new ArrayList<>();
        String[] ballTokens = value.split("");

        for (int i = 0; i < BALL_COUNT; i++) {
            balls.add(new Ball(i + 1, Integer.parseInt(ballTokens[i])));
        }

        return balls;
    }
}
