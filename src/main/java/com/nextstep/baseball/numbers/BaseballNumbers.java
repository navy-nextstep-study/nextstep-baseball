package com.nextstep.baseball.numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class BaseballNumbers {
    private final List<String> numbers;
    private final int BASEBALL_NUMBER_LENGTH = 3;

    public BaseballNumbers(String inputGameNumber) {
        numbers = splitNumber(inputGameNumber);
        checkIsNumber();
        checkNumberLength();
        checkNumeberDuplication();
    }

    private List<String> splitNumber(String inputGameNumber){
        return Arrays.asList(inputGameNumber.split(""));
    }

    private void checkIsNumber(){
        boolean isNumber = numbers.stream()
                .allMatch(num -> Pattern.matches("[1-9]",num));

        if(!isNumber){
            throw new IllegalArgumentException("숫자가 아닌 값을 입력하셨습니다.");
        }
    }

    private void checkNumberLength(){
        if(numbers.size() != BASEBALL_NUMBER_LENGTH){
            throw new IllegalArgumentException("입력하신 숫자의 개수가 3개가 아닙니다.");
        }
    }

    private void checkNumeberDuplication(){
        long listLength = numbers.stream()
                .distinct()
                .count();

        if(listLength != BASEBALL_NUMBER_LENGTH){
            throw new IllegalArgumentException("동일한 숫자를 입력하셨습니다.");
        }
    }

    public List<String> getNumbers() {
        return numbers;
    }
}
