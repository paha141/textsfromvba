package backtovenus;

import abstractClasses.Win;

import java.util.Locale;

public class BackToVenusWin extends Win {
    private boolean isMultiplierLine = false;
    private int multiplier;

    private static final int[][] PAYOUTS = new int[][] {
            {30, 100, 300},
            {20, 60, 120},
            {15, 40, 80},
            {10, 30, 60},
            {10, 30, 60},
            {10, 30, 60},
            {5, 15, 30},
            {5, 15, 30},
            {5, 10, 20},
            {5, 10, 20}
    };


    public BackToVenusWin(int line, int symbolId, int countOfSymbols) {
        super(line, symbolId, countOfSymbols);
        payout = PAYOUTS[symbolId-1][countOfSymbols-3];
    }

    public BackToVenusWin(int line, int symbolId, int countOfSymbols, int multiplier) {
        this(line, symbolId, countOfSymbols);
        this.isMultiplierLine = true;
        this.multiplier = multiplier;
        payout *= multiplier;
    }

    @Override
    public String toString() {
        if (!isMultiplierLine)
        return String.format(Locale.ENGLISH, "line %d: %dx %s symbol cost %d credits;", line, countOfSymbols, BackToVenusSymbols.values()[symbolId - 1].toString(), payout);
        else {
            String result = "line %d: %d (multiplier) * %d (%dx %s symbol) = %d credits;";
            return String.format(Locale.ENGLISH, result, line, multiplier, payout/multiplier, countOfSymbols, BackToVenusSymbols.values()[symbolId - 1].toString(), payout);
        }
    }

    public boolean isMultiplierLine() {
        return isMultiplierLine;
    }

    public int getMultiplier() {
        return multiplier;
    }
}