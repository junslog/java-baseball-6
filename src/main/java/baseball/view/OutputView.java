package baseball.view;


import static baseball.view.constant.output.OutputMessageConstant.INSERT_NUMBERS;
import static baseball.view.constant.output.OutputMessageConstant.INSERT_RESUME;
import static baseball.view.constant.output.OutputMessageConstant.START_GAME;
import static baseball.view.constant.output.OutputNumberConstant.NO_COUNT;
import static baseball.view.constant.output.OutputSymbolConstant.NOTHING;

import baseball.domain.constant.PitchResult;
import baseball.dto.BaseballGameResultDto;
import baseball.view.constant.output.OutputFormatConstant;
import baseball.view.constant.output.OutputSymbolConstant;
import java.util.Map;

public class OutputView {
    public void printStartGame() {
        System.out.print(START_GAME.getMessage());
        printLine();
    }

    public void askUserToInsertNumbers() {
        System.out.print(INSERT_NUMBERS.getMessage());
    }

    public void askUserToRestartOrNot() {
        System.out.println(INSERT_RESUME.getMessage());
    }

    public void printResult(BaseballGameResultDto baseballGameResultDto) {
        Map<PitchResult, Integer> baseballGameResult = baseballGameResultDto.getBaseballGameResult();
        int strikeCount = baseballGameResult.get(PitchResult.STRIKE);
        int ballCount = baseballGameResult.get(PitchResult.BALL);
        printStrikeAndBall(strikeCount, ballCount);
        printLine();
    }

    private void printStrikeAndBall(final int strikeCount, final int ballCount) {
        if (strikeCount == NO_COUNT.getNumber() && ballCount == NO_COUNT.getNumber()) {
            print(NOTHING.getSymbol());
            return;
        }
        if (strikeCount == NO_COUNT.getNumber()) {
            printFormat((OutputFormatConstant.ONLY_BALLS.getFormat()), ballCount);
            return;
        }
        if (ballCount == NO_COUNT.getNumber()) {
            printFormat(OutputFormatConstant.ONLY_STRIKES.getFormat(), strikeCount);
            return;
        }
        if (ballCount > NO_COUNT.getNumber() && strikeCount > NO_COUNT.getNumber()) {
            printFormat(OutputFormatConstant.BALLS_AND_STRIKES.getFormat(), ballCount, strikeCount);
        }
    }

    private void print(final String message) {
        System.out.print(message);
    }

    private void printLine() {
        print(OutputSymbolConstant.NEW_LINE.getSymbol());
    }

    private void printFormat(final String format, Object... args) {
        System.out.printf(format, args);
    }
}