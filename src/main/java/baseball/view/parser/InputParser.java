package baseball.view.parser;


import static baseball.view.constant.InputNumberConstant.RESUME_INPUT_FALSE_VALUE;
import static baseball.view.constant.InputNumberConstant.RESUME_INPUT_TRUE_VALUE;
import static baseball.view.exception.ErrorMessage.INVALID_RESUME_INPUT;
import static baseball.view.constant.InputSymbolConstant.USER_NUMBERS_SEPARATOR;

import baseball.view.parser.validator.ResumeInputValidator;
import baseball.view.parser.validator.UserNumbersInputValidator;
import java.util.Arrays;
import java.util.List;

public class InputParser {
    private final UserNumbersInputValidator userNumbersInputValidator;
    private final ResumeInputValidator resumeInputValidator;

    public InputParser(UserNumbersInputValidator userNumbersInputValidator, ResumeInputValidator resumeInputValidator){
        this.userNumbersInputValidator = userNumbersInputValidator;
        this.resumeInputValidator = resumeInputValidator;
    }
    public List<Integer> parseUserNumbers(String userInput){
        userNumbersInputValidator.validate(userInput);
        return parseToUserNumbers(userInput);
    }

    public boolean parseResumeInput(final String userInput){
        resumeInputValidator.validate(userInput);
        return parseToResume(userInput);
    }

    private List<Integer> parseToUserNumbers(final String userNumbers){
        return Arrays.stream(userNumbers.split(USER_NUMBERS_SEPARATOR.getSymbol()))
                .map(this::parseToInt)
                .toList();
    }

    public boolean parseToResume(final String userInput){
        int parsedResumeInput = parseToInt(userInput);
        if(parsedResumeInput == RESUME_INPUT_TRUE_VALUE.getValue()){
            return true;
        }
        if(parsedResumeInput == RESUME_INPUT_FALSE_VALUE.getValue()){
            return false;
        }
        throw new IllegalArgumentException(INVALID_RESUME_INPUT.getMessage());
    }

    private int parseToInt(final String userInput){
        return Integer.parseInt(userInput);
    }
}
