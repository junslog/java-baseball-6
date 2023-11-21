package baseball.view.constant;

public enum InputNumberConstant {
    BASEBALL_INPUT_NUMBER(3),
    RESUME_INPUT_LENGTH(1),
    RESUME_INPUT_TRUE_VALUE(1),
    RESUME_INPUT_FALSE_VALUE(2);
    private final int value;

    InputNumberConstant(final int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}