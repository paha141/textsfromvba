package abstractClasses;

public abstract class Win {
    protected int payout;
    protected int line;
    protected int symbolId;
    protected int countOfSymbols;

    public Win(int line, int symbolId, int countOfSymbols) {
        this.line = line;
        this.symbolId = symbolId;
        this.countOfSymbols = countOfSymbols;
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
}