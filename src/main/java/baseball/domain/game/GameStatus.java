package baseball.domain.game;

public enum GameStatus {
    PLAY, STOP, RETRY;

    public boolean isPlay() {
        return this == PLAY;
    }

    public boolean isRetry() {
        return this == RETRY;
    }
}
