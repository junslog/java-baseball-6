package baseball.domain;

import static baseball.domain.constant.NumberConstant.THREE_STRIKE_COUNT;
import static baseball.domain.constant.PitchResult.STRIKE;

import baseball.domain.constant.PitchResult;
import java.util.Map;

public class BaseballGameResult {
    private final Map<PitchResult, Integer> baseballGameResult;

    private BaseballGameResult(Map<PitchResult, Integer> baseballGameResult) {
        this.baseballGameResult = baseballGameResult;
    }

    public static BaseballGameResult from(Map<PitchResult, Integer> baseballGameResult) {
        return new BaseballGameResult(baseballGameResult);
    }

    public boolean isThreeStrike() {
        return (baseballGameResult.get(STRIKE) == THREE_STRIKE_COUNT.getValue());
    }
}
