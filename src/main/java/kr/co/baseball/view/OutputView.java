package kr.co.baseball.view;

import kr.co.baseball.dto.ResponseDTO;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OutputView {

    public static void outputResult(ResponseDTO result) {
        System.out.print(result.getBall() + "볼" + " " + result.getStrike() + "스트라이크\n");
    }

    public static void outputNoBall(ResponseDTO result) {
        System.out.print(result.getStrike() + "스트라이크\n");
    }

    public static void outputNoStrike(ResponseDTO result) {
        System.out.print(result.getBall() + "볼\n");
    }

    public static void outputNothing() {
        System.out.print("낫싱\n");
    }

    public static void outputSuccess() {
        System.out.print("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n");
    }
}
