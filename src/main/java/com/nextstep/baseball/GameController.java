package com.nextstep.baseball;

import com.nextstep.baseball.dto.GameResult;
import com.nextstep.baseball.io.Console;
import com.nextstep.baseball.menu.Menu;

public class GameController {
    private boolean gameStatus = true;
    private boolean restartStatus = true;
    private final Console console;

    public GameController() {
        this.console = Console.getInstance();
    }

    public void run(){
        do {
            console.outputInputMessage();
            String inputGameNumber = console.inputGameNum();
            checkRestart();

            GameResult gameResult = new GameResult();// compare.compareNumber(baseballNumbers, randomNumbers);

            checkGameResult(gameResult);
        } while(gameStatus);
    }

    private void checkRestart(){
        if(restartStatus){

        }
    }

    private void checkGameResult(GameResult gameResult){
        if(gameResult.isResult()){
            console.outputMenuSelect();
            String inputMenuNum = console.inputMenuNum();
            return;
        }
        console.outputResult(gameResult);
    }

    private void checkInputMenuNum(String inputMenuNum){
        Menu menu = Menu.findMenu(inputMenuNum);
        if(Menu.RESTART == menu){
            return;
        }
        console.outputEndGame();
    }
}
