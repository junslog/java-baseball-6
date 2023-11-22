package baseball.view.constant.output;

import static baseball.view.constant.input.InputNumberConstant.RESUME_INPUT_FALSE_VALUE;
import static baseball.view.constant.input.InputNumberConstant.RESUME_INPUT_TRUE_VALUE;
import static baseball.view.constant.output.OutputSymbolConstant.NEW_LINE;

public enum OutputMessageConstant {
    START_GAME("숫자 야구 게임을 시작합니다."),
    INSERT_NUMBERS("숫자를 입력해주세요 : "),
    INSERT_RESUME(
            "3개의 숫자를 모두 맞추셨습니다! 게임 종료" + NEW_LINE.getSymbol() + "게임을 새로 시작하려면 " + RESUME_INPUT_TRUE_VALUE.getValue()
                    + " 종료하려면 " + RESUME_INPUT_FALSE_VALUE.getValue() + "를 입력하세요.");

    private final String message;

    OutputMessageConstant(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}