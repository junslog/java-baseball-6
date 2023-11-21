package baseball.dto;

import baseball.domain.constant.PitchResult;
import java.util.Map;

public class BaseballResultDto {
    private Map<PitchResult, Integer> baseballResult;

    private BaseballGameResult(Map<PitchResult, Integer> baseballResult) {

    }

}