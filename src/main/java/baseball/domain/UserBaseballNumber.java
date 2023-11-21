package baseball.domain;

import static baseball.domain.exception.message.ErrorMessage.SHOULD_INPUT_LENGTH_THREE;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserBaseballNumber {
    private final List<Number> userBaseballNumbers;

    private UserBaseballNumber(List<Number> baseballNumbers) {
        userBaseballNumbers = baseballNumbers;
    }

    public static UserBaseballNumber from(List<Integer> userBaseballNumbers) {
        validateBaseballInput(userBaseballNumbers);
        return new UserBaseballNumber(parseToNumbers(userBaseballNumbers));
    }

    private static void validateBaseballInput(List<Integer> userBaseballNumbers) {
        checkNotExistDuplication(userBaseballNumbers);
    }

    private static void checkNotExistDuplication(List<Integer> userBaseballNumbers) {
        Set<Integer> duplicateCheckSet = new HashSet<>(userBaseballNumbers);
        if (duplicateCheckSet.size() != userBaseballNumbers.size()) {
            throw new IllegalArgumentException(SHOULD_INPUT_LENGTH_THREE.getMessage());
        }
    }

    private static List<Number> parseToNumbers(List<Integer> userBaseballNumbers) {
        return userBaseballNumbers.stream()
                .map(Number::from)
                .toList();
    }

    public Number getNumberByDigit(final int digit) {
        return userBaseballNumbers.get(digit);
    }

    public int getNumbersSize() {
        return userBaseballNumbers.size();
    }
}