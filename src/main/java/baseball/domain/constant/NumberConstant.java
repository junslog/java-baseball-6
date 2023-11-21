package baseball.domain.constant;

public enum NumberConstant {
    BASEBALL_NUMBER_MIN_VALUE(1),
    BASEBALL_NUMBER_MAX_VALUE(9),
    STRIKE_ADD_AMOUNT(1),
    BALL_ADD_AMOUNT(1),
    THREE_STRIKE_COUNT(3);

    private final int value;

    NumberConstant(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}