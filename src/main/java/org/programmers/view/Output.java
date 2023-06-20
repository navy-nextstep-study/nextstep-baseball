package org.programmers.view;

import org.programmers.model.Result;

public interface Output {
    void printInputMessage();

    void printResult(Result result); //dto 이용

    void printFinishMessage();

    void printRetryMessage();
}
