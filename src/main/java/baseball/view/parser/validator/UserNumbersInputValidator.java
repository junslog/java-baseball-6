package baseball.view.parser.validator;

import static baseball.view.constant.input.InputNumberConstant.BASEBALL_INPUT_NUMBER;
import static baseball.view.exception.message.IoErrorMessage.INVALID_BALLS_LENGTH;
import static baseball.view.exception.message.IoErrorMessage.NOT_NUMERIC_TYPE;

public class UserNumbersInputValidator {
    public void validate(String userNumbersInput) {
        checkLength(userNumbersInput);
        checkIsNumberFormat(userNumbersInput);
    }

    private void checkLength(String userInput) {
        if (userInput.length() != BASEBALL_INPUT_NUMBER.getValue()) {
            throw new IllegalArgumentException(INVALID_BALLS_LENGTH.getMessage());
        }
    }

    private void checkIsNumberFormat(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(NOT_NUMERIC_TYPE.getMessage());
        }
    }
}