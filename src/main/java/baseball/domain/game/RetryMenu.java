package baseball.domain.game;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum RetryMenu {
    RETRY("1"), EXIT("2");

    private final String menuNumber;
    private final static Map<String, RetryMenu> RETRY_MENU_MAP = Collections.unmodifiableMap(Arrays.stream(values())
            .collect(Collectors.toMap(RetryMenu::getMenuNumber, Function.identity())));

    RetryMenu(String menuNumber) {
        this.menuNumber = menuNumber;
    }

    private String getMenuNumber() {
        return this.menuNumber;
    }

    public static Optional<RetryMenu> findRetryMenu(String inputNumber) {
        return Optional.ofNullable(RETRY_MENU_MAP.get(inputNumber));
    }
}
