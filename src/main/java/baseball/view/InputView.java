package baseball.view;


import baseball.view.parser.InputParser;
import baseball.view.parser.validator.ResumeInputValidator;
import baseball.view.parser.validator.UserNumbersInputValidator;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;


public class InputView {
    private final InputParser inputParser;

    public InputView(){
        this.inputParser = new InputParser(new UserNumbersInputValidator(), new ResumeInputValidator());
    }

    public List<Integer> getUserBaseballNumber(){
        return inputParser.parseUserNumbers(readLine());
    }

    public boolean getResumeInput(){
        return inputParser.parseResumeInput(readLine());
    }

    private String readLine(){
        return Console.readLine();
    }
}