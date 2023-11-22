package baseball.dto;

import baseball.domain.constant.PitchResult;
import java.util.Collections;
import java.util.Map;

public class BaseballGameResultDto {
    private final Map<PitchResult, Integer> baseballGameResult;

    private BaseballGameResultDto(Map<PitchResult, Integer> baseballGameResult) {
        this.baseballGameResult = baseballGameResult;
    }

    public static BaseballGameResultDto from(Map<PitchResult, Integer> baseballGameResult) {
        return new BaseballGameResultDto(baseballGameResult);
    }

    public Map<PitchResult, Integer> getBaseballGameResult() {
        return Collections.unmodifiableMap(baseballGameResult);
    }
}