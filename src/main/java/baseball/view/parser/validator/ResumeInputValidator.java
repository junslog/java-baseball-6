package baseball.view.parser.validator;

import static baseball.view.constant.InputNumberConstant.RESUME_INPUT_LENGTH;
import static baseball.view.exception.ErrorMessage.RESUME_LENGTH_OVER_LIMIT;
import static baseball.view.exception.ErrorMessage.NOT_NUMERIC_TYPE;

public class ResumeInputValidator {

    public void validate(final String userResumeInput) {
        checkLength(userResumeInput);
        checkIsNumericFormat(userResumeInput);
    }

    private void checkLength(final String userInput){
        if(userInput.length() != RESUME_INPUT_LENGTH.getValue()){
            throw new IllegalArgumentException(RESUME_LENGTH_OVER_LIMIT.getMessage());
        }
    }
    private void checkIsNumericFormat(String userInput){
        try{
            Integer.parseInt(userInput);
        } catch(NumberFormatException e){
            throw new IllegalArgumentException(NOT_NUMERIC_TYPE.getMessage());
        }
    }
}