package abstractClasses;

public abstract class Win {
    protected int line;
    protected int symbolId;
    protected int countOfSymbols;

    private boolean isMultiplierLine;
    private int multiplier;

    protected int payout;
    protected Symbols symbol;

    private static final String MESSAGE_SIMPLE = "%dx %s symbol cost %d credits;";
    private static final String MESSAGE_WITH_MULTIPLIER = "%d (multiplier) * %d (%dx %s symbol) = %d credits;";
    private static final String MESSAGE_SCATTER = "Scatter Win: %dx %s cost %d credits;";

    public Win(int line, int symbolId, int countOfSymbols) {
        this(line, symbolId, countOfSymbols, 1);
    }

    public Win(int line, int symbolId, int countOfSymbols, int multiplier) {
        this.line = line;
        this.symbolId = symbolId;
        this.countOfSymbols = countOfSymbols;
        this.multiplier = multiplier;
        isMultiplierLine = multiplier > 1;
    }

    public int getPayout() {
        return payout;
    }

    public void setPayout(int payout) {
        this.payout = payout;
    }

    public int getLine() {
        return line;
    }

    public int getSymbolId() {
        return symbolId;
    }

    public int getCountOfSymbols() {
        return countOfSymbols;
    }

    public boolean isMultiplierLine() {
        return isMultiplierLine;
    }

    public void setMultiplierLine(boolean multiplierLine) {
        isMultiplierLine = multiplierLine;
    }

    public int getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(int multiplier) {
        this.multiplier = multiplier;
    }

    public Symbols getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        if (line == -1) return String.format(MESSAGE_SCATTER, countOfSymbols, symbol.getName(), payout);
        if (isMultiplierLine)
            return String.format(MESSAGE_WITH_MULTIPLIER, multiplier, payout / multiplier, countOfSymbols, symbol.getName(), payout);
        return String.format(MESSAGE_SIMPLE, countOfSymbols, symbol.getName(), payout);
    }
}