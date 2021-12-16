package abstractClasses;

public abstract class Win implements Comparable<Win> {
    private final int line;
    private final int symbolId;
    private final int countOfSymbols;

    private int multiplier;

    protected int payout;
    protected Symbol symbol;

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
        return multiplier != 1;
    }

    public int getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(int multiplier) {
        this.multiplier = multiplier;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        if (line == -1) return String.format(MESSAGE_SCATTER, countOfSymbols, symbol.getName(), payout);
        if (isMultiplierLine())
            return String.format(MESSAGE_WITH_MULTIPLIER, multiplier, payout / multiplier, countOfSymbols, symbol.getName(), payout);
        return String.format(MESSAGE_SIMPLE, countOfSymbols, symbol.getName(), payout);
    }

    @Override
    public int compareTo(Win win) {
        return payout - win.getPayout();
    }
}