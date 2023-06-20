package baseball.domain.game;

import baseball.domain.ball.Ball;
import baseball.domain.ball.BallStatus;

import java.util.List;

public class Referee {

    public PlayResult judgement(List<Ball> computerBalls, List<Ball> userBalls) {

        PlayResult playResult = new PlayResult();

        for (Ball ball : userBalls) {
            BallStatus status = getBallStatus(computerBalls, ball);
            updateResult(playResult, status);
        }

        return playResult;
    }

    private BallStatus getBallStatus(List<Ball> computerBalls, Ball ball) {
        return computerBalls.stream()
                .map(computerBall -> computerBall.compare(ball))
                .filter(BallStatus::isNotNothing)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }

    private void updateResult(PlayResult playResult, BallStatus status) {
        switch (status) {
            case STRIKE:
                playResult.addStrike();
                break;
            case BALL:
                playResult.addBall();
        }
    }
}
