package baseball.domain.constant;

public enum PitchResult {
    STRIKE("스트라이크"),
    BALL("볼");
    private final String symbol;

    PitchResult(final String symbol){
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}