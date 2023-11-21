package baseball.controller;


import baseball.domain.BaseballGameResult;
import baseball.domain.ComputerBaseballNumber;
import baseball.domain.ComputerNumbersGenerator;
import baseball.domain.UserBaseballNumber;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;

    public GameController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void playGame() {
        outputView.printStartGame();
        do {
            ComputerBaseballNumber computerBaseballNumber = ComputerBaseballNumber.from(
                    ComputerNumbersGenerator.generate());
            outputView.askUserToInsertNumbers();
            UserBaseballNumber userBaseballNumber = UserBaseballNumber.from(inputView.getUserBaseballNumber());
            BaseballGameResult baseballGameResult = computerBaseballNumber.makeBaseballGameResult(userBaseballNumber);
            if (isThreeStrike(baseballGameResult) || !resumeGame()) {
                break;
            }
        } while (true);
    }

    private boolean resumeGame() {
        return inputView.getResumeInput();
    }

    private boolean isThreeStrike(BaseballGameResult baseballGameResult) {
        return baseballGameResult.isThreeStrike();
    }
}
