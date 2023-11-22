package baseball.domain;


import static baseball.domain.constant.NumberConstant.BASEBALL_NUMBER_MAX_VALUE;
import static baseball.domain.constant.NumberConstant.BASEBALL_NUMBER_MIN_VALUE;
import static baseball.domain.exception.message.ErrorMessage.INVALID_NUMBER;

import java.util.Objects;

public class BaseballNumber {
    private final int number;

    private BaseballNumber(final int number) {
        this.number = number;
    }

    public static BaseballNumber from(final int number) {
        validateRange(number);
        return new BaseballNumber(number);
    }

    private static void validateRange(final int number) {
        if (number < BASEBALL_NUMBER_MIN_VALUE.getValue() || number > BASEBALL_NUMBER_MAX_VALUE.getValue()) {
            throw new IllegalArgumentException(INVALID_NUMBER.getMessage());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BaseballNumber baseballNumber = (BaseballNumber) o;
        return number == baseballNumber.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}