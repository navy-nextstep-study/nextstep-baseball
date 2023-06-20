package baseball.domain.game;

import baseball.domain.ball.Ball;
import baseball.domain.ball.BallGenerator;
import io.Console;

import java.util.List;

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

        } while (gameStatus.isPlay());
    }

    @Override
    public boolean isPlaying() {
        return gameStatus.isPlay() || gameStatus.isRetry();
    }
}
