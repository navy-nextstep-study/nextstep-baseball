package com.nextstep.baseball;

import com.nextstep.baseball.dto.GameResult;
import com.nextstep.baseball.numbers.BaseballNumbers;
import com.nextstep.baseball.numbers.RandomNumbers;
import com.nextstep.baseball.util.Compare;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CompareTest {

    @Test
    void 입력한값과_생성된값을_비교한다(){
        // given
        BaseballNumbers baseballNumbers = new BaseballNumbers("123");
        RandomNumbers randomNumbers = new RandomNumbers("134");

        GameResult gameResultExpect = new GameResult();
        gameResultExpect.setResult(false);
        gameResultExpect.setBallCount(1);
        gameResultExpect.setStrikeCount(1);

        // when
        GameResult gameResult = Compare.compareNumber(baseballNumbers, randomNumbers);

        // then
        Assertions.assertThat(gameResult).usingRecursiveComparison().isEqualTo(gameResultExpect);
    }
}
