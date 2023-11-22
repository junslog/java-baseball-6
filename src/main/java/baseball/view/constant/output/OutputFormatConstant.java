package baseball.view.constant.output;

import static baseball.view.constant.output.OutputSymbolConstant.BALL;
import static baseball.view.constant.output.OutputSymbolConstant.STRIKE;

public enum OutputFormatConstant {
    ONLY_BALLS("%d" + BALL.getSymbol()),
    ONLY_STRIKES("%d" + STRIKE.getSymbol()),
    BALLS_AND_STRIKES(ONLY_BALLS.format + " " + ONLY_STRIKES.format);

    private final String format;

    OutputFormatConstant(final String format) {
        this.format = format;
    }

    public String getFormat() {
        return format;
    }
}