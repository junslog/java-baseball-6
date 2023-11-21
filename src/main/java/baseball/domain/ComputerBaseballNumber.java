package baseball.domain;

import static baseball.domain.constant.NumberConstant.BALL_ADD_AMOUNT;
import static baseball.domain.constant.NumberConstant.STRIKE_ADD_AMOUNT;
import static baseball.domain.constant.PitchResult.BALL;
import static baseball.domain.constant.PitchResult.STRIKE;

import baseball.domain.constant.PitchResult;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComputerBaseballNumber {
    private final List<Number> computerBaseballNumber;

    public ComputerBaseballNumber(List<Number> numbers) {
        computerBaseballNumber = numbers;
    }

    public static ComputerBaseballNumber from(List<Integer> generatedNumbers) {
        return new ComputerBaseballNumber(parseGeneratedNumber(generatedNumbers));
    }

    private static List<Number> parseGeneratedNumber(List<Integer> generatedNumbers) {
        return generatedNumbers.stream()
                .map(Number::from)
                .toList();
    }

    public BaseballGameResult makeBaseballGameResult(UserBaseballNumber userBaseballNumber) {
        Map<PitchResult, Integer> baseballGameResult = new HashMap<>();
        baseballGameResult.put(STRIKE, 0);
        baseballGameResult.put(BALL, 0);
        for (int i = 0; i < userBaseballNumber.getNumbersSize(); i++) {
            countStrikeAndBall(userBaseballNumber, i, baseballGameResult);
        }
        return BaseballGameResult.from(baseballGameResult);
    }

    private void countStrikeAndBall(UserBaseballNumber userBaseballNumber, int digit,
                                    Map<PitchResult, Integer> baseballGameResult) {
        Number userNumber = userBaseballNumber.getNumberByDigit(digit);
        if (userNumber.equals(computerBaseballNumber.get(digit))) {
            baseballGameResult.put(STRIKE, baseballGameResult.get(STRIKE) + STRIKE_ADD_AMOUNT.getValue());
        } else if (computerBaseballNumber.contains(userNumber)) {
            baseballGameResult.put(BALL, baseballGameResult.get(BALL) + BALL_ADD_AMOUNT.getValue());
        }
    }
}
