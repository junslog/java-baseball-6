package baseball.view.constant.output;

import baseball.domain.constant.PitchResult;

public enum OutputSymbolConstant {

    NOTHING("낫싱"),
    BALL(PitchResult.BALL.getSymbol()),
    STRIKE(PitchResult.STRIKE.getSymbol()),
    NEW_LINE(System.lineSeparator());

    private final String symbol;

    OutputSymbolConstant(final String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}