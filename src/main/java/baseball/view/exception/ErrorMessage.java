package baseball.view.exception;

import static baseball.view.constant.InputNumberConstant.RESUME_INPUT_LENGTH;

public enum ErrorMessage {
    PREFIX("[ERROR] "),
    RESUME_LENGTH_OVER_LIMIT(PREFIX.message + "잘못된 사용자 입력입니다. : 입력의 길이가" + RESUME_INPUT_LENGTH.getValue() + "이 아닙니다."),
    NOT_NUMERIC_TYPE(PREFIX.message + "잘못된 사용자 입력입니다. : 숫자 형식의 입력이 아닙니다."),
    INVALID_RESUME_INPUT("잘못된 사용자 입력입니다.");

    private final String message;
    ErrorMessage(final String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
