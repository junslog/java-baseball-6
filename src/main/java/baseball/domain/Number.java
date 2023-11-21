package baseball.domain;


import static baseball.domain.constant.NumberConstant.BASEBALL_NUMBER_MAX_VALUE;
import static baseball.domain.constant.NumberConstant.BASEBALL_NUMBER_MIN_VALUE;
import static baseball.domain.exception.message.ErrorMessage.INVALID_NUMBER;

import java.util.Objects;

public class Number {
    private final int number;

    private Number(final int number) {
        this.number = number;
    }

    public static Number from(final int number) {
        validateRange(number);
        return new Number(number);
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
        Number number1 = (Number) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    public int getNumber() {
        return number;
    }
}