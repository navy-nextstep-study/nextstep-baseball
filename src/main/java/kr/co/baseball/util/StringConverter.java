package kr.co.baseball.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StringConverter {
    private static final String DELIMINATOR = "";

    public static List<Integer> convert(String input) throws IllegalArgumentException {
        return Arrays.stream(input.split(DELIMINATOR))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }
}
