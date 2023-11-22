package baseball.view.constant.output;

public enum OutputNumberConstant {
    NO_COUNT(0);
    private final int number;

    OutputNumberConstant(final int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}