package io;

import baseball.domain.game.PlayResult;

public interface Output {

    void outputRequestNumberMsg();

    void outputGameResult(PlayResult result);

    void outputRequestRetryMsg();

    void outputCorrectAnswerMsg();
}
