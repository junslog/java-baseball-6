package baseball.view.constant;

public enum InputSymbolConstant {
    USER_NUMBERS_SEPARATOR("");

    private final String symbol;

    InputSymbolConstant(final String symbol){
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}