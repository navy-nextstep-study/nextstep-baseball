package kr.co.baseball.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class ResponseDTO {

    private int strike;
    private int ball;
}
