package com.nextstep.baseball.io;

import com.nextstep.baseball.dto.GameResult;

public interface Io {

    String inputGameNum();
    String inputMenuNum();
    void outputInputMessage();
    void outputResult(GameResult result);
    void outputEndGame();
    void outputMenuSelect();
}
