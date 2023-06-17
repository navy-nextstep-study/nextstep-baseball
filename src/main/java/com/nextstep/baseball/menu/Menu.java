package com.nextstep.baseball.menu;

import java.util.Arrays;

public enum Menu {
    RESTART("1"),
    END("2");

    private final String status;

    Menu(String status) {
        this.status = status;
    }

    public static Menu findMenu(String inputMenu){
        return Arrays.stream(values())
                .filter(value -> value.status.equals(inputMenu))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("찾는 메뉴가 없습니다."));
    }
}
