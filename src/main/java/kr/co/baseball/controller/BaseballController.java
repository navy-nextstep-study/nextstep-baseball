package kr.co.baseball.controller;

public class BaseballController {
    private boolean isRun = false;

    public void runBaseball() {
        isRun = true;
    }

    public boolean isRunBaseball() {
        return isRun;
    }
}
