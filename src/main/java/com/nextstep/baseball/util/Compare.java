package com.nextstep.baseball.util;

import com.nextstep.baseball.dto.GameResult;
import com.nextstep.baseball.numbers.BaseballNumbers;
import com.nextstep.baseball.numbers.RandomNumbers;

import java.util.List;

public class Compare {

    private static GameResult gameResult;

    public static GameResult compareNumber(BaseballNumbers baseballNumbers, RandomNumbers randomNumbers){
        gameResult = new GameResult();

        for(int i = 0; i < 3; i++){
            isStrike(i, baseballNumbers.getNumbers(), randomNumbers.getNumbers());
        }

        return gameResult;
    }

    private static void isStrike(int index, List<String> baseballNumbers, List<String> randomNumbers){
        if(randomNumbers.get(index).equals(baseballNumbers.get(index))){
            gameResult.setStrikeCount(gameResult.getStrikeCount()+1);
            return;
        }

        isBall(index, baseballNumbers, randomNumbers);
    }

    private static void isBall(int index, List<String> baseballNumbers, List<String> randomNumbers) {
        if(randomNumbers.contains(baseballNumbers.get(index))){
            gameResult.setBallCount(gameResult.getBallCount()+1);
        }
    }
}
