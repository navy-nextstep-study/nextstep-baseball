package camp.nextstep.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringSplitter {

    private static final String DELIMINATOR = "";

    public static List<Integer> splitToList(String input) {
        String[] result = input.split(DELIMINATOR);
        return Arrays.stream(result).map(Integer::parseInt).collect(Collectors.toList());
    }
}
