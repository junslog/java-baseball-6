package baseball.domain;

import static baseball.domain.constant.NumberConstant.THREE_STRIKE_COUNT;
import static baseball.domain.constant.PitchResult.BALL;
import static baseball.domain.constant.PitchResult.STRIKE;

import baseball.domain.constant.PitchResult;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

public class BaseballGameResult {
    private final EnumMap<PitchResult, Integer> baseballGameResult;

    private BaseballGameResult(EnumMap<PitchResult, Integer> baseballGameResult) {
        this.baseballGameResult = baseballGameResult;
    }

    public static BaseballGameResult from(final int strikeCount, final int ballCount) {
        return new BaseballGameResult(parseToBaseballGameResult(strikeCount, ballCount));
    }

    private static EnumMap<PitchResult, Integer> parseToBaseballGameResult(final int strikeCount, final int ballCount) {
        EnumMap<PitchResult, Integer> baseballResult = new EnumMap<>(PitchResult.class);
        baseballResult.put(STRIKE, strikeCount);
        baseballResult.put(BALL, ballCount);
        return baseballResult;
    }

    public boolean isThreeStrike() {
        return (baseballGameResult.get(STRIKE) == THREE_STRIKE_COUNT.getValue());
    }

    public Map<PitchResult, Integer> getBaseballGameResult() {
        return Collections.unmodifiableMap(baseballGameResult);
    }
}