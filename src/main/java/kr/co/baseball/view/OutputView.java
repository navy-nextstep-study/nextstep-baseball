package kr.co.baseball.view;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OutputView {

    public static void outputResult(int[] result){
        System.out.print(result[1] + "볼" + " " + result[0] + "스트라이크\n");
    }

    public static void outputNoBall(int[] result){
        System.out.print(result[0] + "스트라이크\n");
    }

    public static void outputNoStrike(int[] result){
        System.out.print(result[1] + "볼\n");
    }

    public static void outputNothing(){
        System.out.print("낫싱\n");
    }

    public static void outputSuccess(){
        System.out.print("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n");
    }
}
