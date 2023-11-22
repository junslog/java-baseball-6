package baseball.view.exception.message;

import static baseball.global.Constants.ERROR_PREFIX;
import static baseball.view.constant.input.InputNumberConstant.BASEBALL_INPUT_NUMBER;
import static baseball.view.constant.input.InputNumberConstant.RESUME_INPUT_FALSE_VALUE;
import static baseball.view.constant.input.InputNumberConstant.RESUME_INPUT_LENGTH;
import static baseball.view.constant.input.InputNumberConstant.RESUME_INPUT_TRUE_VALUE;

public enum IoErrorMessage {
    RESUME_LENGTH_OVER_LIMIT("잘못된 사용자 입력입니다. : 입력의 길이가" + RESUME_INPUT_LENGTH.getValue() + "이 아닙니다."),
    NOT_NUMERIC_TYPE("잘못된 사용자 입력입니다. : 숫자 형식의 입력이 아닙니다."),
    INVALID_RESUME_INPUT(
            "잘못된 사용자 입력입니다." + RESUME_INPUT_TRUE_VALUE.getValue() + "또는 " + RESUME_INPUT_FALSE_VALUE.getValue()
                    + "를 입력해주세요."),
    INVALID_BALLS_LENGTH("잘못된 사용자 입력입니다. : 입력의 길이가 " + BASEBALL_INPUT_NUMBER + "이 아닙니다.");

    private final String message;

    IoErrorMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_PREFIX + message;
    }
}
