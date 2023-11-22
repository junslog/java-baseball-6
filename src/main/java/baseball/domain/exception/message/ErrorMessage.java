package baseball.domain.exception.message;

import static baseball.global.Constants.ERROR_PREFIX;

public enum ErrorMessage {
    INVALID_NUMBER("잘못된 숫자 입력 범위입니다."),
    SHOULD_INPUT_LENGTH_THREE("세 개의 숫자를 입력해주셔야 합니다."),
    DUPLICATED_NUMBERS("중복된 숫자 입력입니다.");

    private final String message;

    ErrorMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_PREFIX + message;
    }
}