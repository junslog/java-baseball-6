package baseball.view.parser.validator;

import static baseball.view.constant.InputNumberConstant.BASEBALL_INPUT_NUMBER;

public class UserNumbersInputValidator {
    public void validate(String userNumbersInput) {
        checkLength(userNumbersInput);
        checkIsNumberFormat(userNumbersInput);
    }

    private void checkLength(String userInput) {
        if (userInput.length() != BASEBALL_INPUT_NUMBER.getValue()) {
            throw new IllegalArgumentException("잘못된 사용자 입력입니다. : 입력의 길이가 " + BASEBALL_INPUT_NUMBER + "이 아닙니다.");
        }
    }

    private void checkIsNumberFormat(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("잘못된 사용자 입력입니다. : 숫자 형식의 입력이 아닙니다.");
        }
    }
}