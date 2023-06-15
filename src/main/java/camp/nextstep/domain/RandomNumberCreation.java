package camp.nextstep.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumberCreation implements NumberCreationStrategy{

    private static final Random RANDOM = new Random();

    @Override
    public List<Integer> create() {
        List<Integer> result = new ArrayList<>();
        result.add(RANDOM.nextInt(9) + 1);
        result.add(RANDOM.nextInt(9) + 1);
        result.add(RANDOM.nextInt(9) + 1);
        return result;
    }
}
