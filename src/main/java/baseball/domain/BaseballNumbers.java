package baseball.domain;

import static baseball.domain.exception.message.ErrorMessage.DUPLICATED_NUMBERS;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class BaseballNumbers {

    private final List<BaseballNumber> ballNumbers;

    private BaseballNumbers(List<BaseballNumber> ballNumbers) {
        this.ballNumbers = ballNumbers;
    }

    public static BaseballNumbers createComputerBalls(List<Integer> computerNumbers) {
        return new BaseballNumbers(parseToNumbers(computerNumbers));
    }

    public static BaseballNumbers createUserBalls(List<Integer> userNumbers) {
        validateUserBaseballs(userNumbers);
        return new BaseballNumbers(parseToNumbers(userNumbers));
    }

    private static List<BaseballNumber> parseToNumbers(List<Integer> generatedNumbers) {
        return generatedNumbers.stream()
                .map(BaseballNumber::from)
                .toList();
    }

    private static void validateUserBaseballs(List<Integer> userBaseballNumbers) {
        checkNotExistDuplication(userBaseballNumbers);
    }

    private static void checkNotExistDuplication(List<Integer> userBaseballNumbers) {
        Set<Integer> duplicateCheckSet = new HashSet<>(userBaseballNumbers);
        if (duplicateCheckSet.size() != userBaseballNumbers.size()) {
            throw new IllegalArgumentException(DUPLICATED_NUMBERS.getMessage());
        }
    }

    public BaseballGameResult makeBaseballResult(BaseballNumbers baseballNumbers) {
        int strikeCount = (int) IntStream.range(0, baseballNumbers.ballNumbers.size())
                .filter(index -> isStrike(index, baseballNumbers.ballNumbers))
                .count();

        int ballCount = (int) IntStream.range(0, baseballNumbers.ballNumbers.size())
                .filter(index ->
                        !isStrike(index, baseballNumbers.ballNumbers) &&
                                isBall(index, baseballNumbers.ballNumbers))
                .count();
        return BaseballGameResult.from(strikeCount, ballCount);
    }

    private boolean isStrike(final int index, List<BaseballNumber> ballNumbers) {
        return this.ballNumbers.get(index).equals(ballNumbers.get(index));
    }

    private boolean isBall(final int index, List<BaseballNumber> ballNumbers) {
        return this.ballNumbers.contains(ballNumbers.get(index));
    }
}