package baseball.controller;


import baseball.domain.BaseballGameResult;
import baseball.domain.BaseballNumbers;
import baseball.domain.util.ComputerBallsGenerator;
import baseball.dto.BaseballGameResultDto;
import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Console;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;

    public GameController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void playGame() {
        outputView.printStartGame();
        boolean restartFlag = true;
        while (restartFlag) {
            BaseballNumbers computerBalls = BaseballNumbers.createComputerBalls(ComputerBallsGenerator.generate());

            playUntilEndGameCondition(computerBalls);

            outputView.askUserToRestartOrNot();
            restartFlag = judgeRestartOrNot();
        }
        terminateGame();
    }

    private void playUntilEndGameCondition(BaseballNumbers computerBalls) {
        boolean proceedGame = true;
        while (proceedGame) {
            outputView.askUserToInsertNumbers();
            BaseballNumbers userBalls = BaseballNumbers.createUserBalls(inputView.getUserBaseballNumber());
            BaseballGameResult baseballGameResult = computerBalls.makeBaseballResult(userBalls);
            outputView.printResult(BaseballGameResultDto.from(baseballGameResult.getBaseballGameResult()));
            proceedGame = isEndGameCondition(baseballGameResult);
        }
    }

    private boolean isEndGameCondition(BaseballGameResult baseballGameResult) {
        return !baseballGameResult.isThreeStrike();
    }

    private boolean judgeRestartOrNot() {
        return inputView.getResumeInput();
    }

    private void terminateGame() {
        Console.close();
    }
}