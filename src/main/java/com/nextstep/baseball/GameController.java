package com.nextstep.baseball;

import com.nextstep.baseball.dto.GameResult;
import com.nextstep.baseball.io.Console;
import com.nextstep.baseball.menu.Menu;
import com.nextstep.baseball.numbers.BaseballNumbers;
import com.nextstep.baseball.numbers.RandomNumbers;
import com.nextstep.baseball.util.Compare;

public class GameController {
    private boolean gameStatus = true;
    private boolean restartStatus = true;
    private final Console console;
    private BaseballNumbers baseballNumbers;
    private RandomNumbers randomNumbers;

    public GameController() {
        this.console = Console.getInstance();
    }

    public void run(){
        do {
            console.outputInputMessage();
            String inputGameNumber = console.inputGameNum();
            checkRestart(inputGameNumber);
            GameResult gameResult = Compare.compareNumber(baseballNumbers, randomNumbers);
            checkGameResult(gameResult);
        } while(gameStatus);
    }

    private void checkRestart(String inputGameNumber){
        if(restartStatus){
            randomNumbers = new RandomNumbers();
            restartStatus = false;
        }

        baseballNumbers = new BaseballNumbers(inputGameNumber);
    }

    private void checkGameResult(GameResult gameResult){
        if(gameResult.isCorrect()){
            console.outputMenuSelect();
            String inputMenuNum = console.inputMenuNum();
            checkInputMenuNum(inputMenuNum);
            return;
        }

        console.outputResult(gameResult);
    }

    private void checkInputMenuNum(String inputMenuNum){
        Menu menu = Menu.findMenu(inputMenuNum);

        if(Menu.RESTART == menu){
            restartStatus = true;
            return;
        }

        console.outputEndGame();
        gameStatus = false;
    }
}
