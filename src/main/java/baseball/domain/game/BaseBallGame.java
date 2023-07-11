package baseball.domain.game;

import baseball.domain.ball.Ball;
import baseball.domain.ball.BallGenerator;
import io.Console;

import java.util.List;
import java.util.Optional;

public class BaseBallGame implements Game {

    Console console;
    Referee referee;
    BallGenerator ballGenerator;
    GameStatus gameStatus;

    public BaseBallGame() {
        console = new Console();
        referee = new Referee();
        ballGenerator = new BallGenerator();
    }

    @Override
    public void play() {
        gameStatus = GameStatus.PLAY;
        List<Ball> computerBalls = ballGenerator.generateBalls();
        do {
            console.outputRequestNumberMsg();
            List<Ball> userBalls = ballGenerator.generateBalls(console.inputUserBalls());
            PlayResult result = referee.judgement(computerBalls, userBalls);
            console.outputGameResult(result);
            checkRetry(result);
        } while (gameStatus.isPlay());
    }

    private void checkRetry(PlayResult result) {
        if (!result.isCorrect()) {
            return;
        }

        if (result.isCorrect()) {
            gameStatus = GameStatus.STOP;
            console.outputCorrectAnswerMsg();
            Optional<RetryMenu> retryMenu = Optional.empty();

            while (retryMenu.isEmpty()) {
                console.outputRequestRetryMsg();
                retryMenu = RetryMenu.findRetryMenu(console.inputRetryNumber());
            }

            if (retryMenu.get() == RetryMenu.RETRY) {
                gameStatus = GameStatus.RETRY;
            }
        }
    }

    @Override
    public boolean isPlaying() {
        return gameStatus.isPlay() || gameStatus.isRetry();
    }
}
