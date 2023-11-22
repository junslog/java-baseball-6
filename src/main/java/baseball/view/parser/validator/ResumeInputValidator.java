package baseball.view.parser.validator;

import static baseball.view.constant.input.InputNumberConstant.RESUME_INPUT_LENGTH;
import static baseball.view.exception.message.IoErrorMessage.NOT_NUMERIC_TYPE;
import static baseball.view.exception.message.IoErrorMessage.RESUME_LENGTH_OVER_LIMIT;

public class ResumeInputValidator {

    public void validate(final String userResumeInput) {
        checkLength(userResumeInput);
        checkIsNumericFormat(userResumeInput);
    }

    private void checkLength(final String userInput) {
        if (userInput.length() != RESUME_INPUT_LENGTH.getValue()) {
            throw new IllegalArgumentException(RESUME_LENGTH_OVER_LIMIT.getMessage());
        }
    }

    private void checkIsNumericFormat(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMERIC_TYPE.getMessage());
        }
    }
}