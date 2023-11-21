package baseball.domain.exception.message;

public enum ErrorMessage {
    INVALID_NUMBER("[ERROR] 잘못된 숫자 입력 범위입니다. 숫자는 1 ~ 9 사이의 입력이어야 합니다."),
    SHOULD_INPUT_LENGTH_THREE("[ERROR] 세 개의 숫자를 입력해주셔야 합니다.");

    private final String message;

    ErrorMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}