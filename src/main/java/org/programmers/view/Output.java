package org.programmers.view;

import org.programmers.model.ResultDto;

public interface Output {
    void printInputMessage();

    void printResult(ResultDto result); //dto 이용

    void printFinishAndRestartMessage();
}
