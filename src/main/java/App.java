import baseball.domain.game.BaseBallGame;
import baseball.domain.game.Game;

public class App {
    public static void main(String[] args) {
        Game game = new BaseBallGame();
        do {
            game.play();
        } while (game.isPlaying());
    }
}
