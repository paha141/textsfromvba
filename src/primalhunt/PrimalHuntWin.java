package primalhunt;

import abstractClasses.Win;

import java.util.Locale;

public class PrimalHuntWin extends Win {
    private boolean isMultiplierLine = false;
    private int multiplier;

    private static final int[][] PAYOUTS = new int[][] {
            {1, 5, 25, 100},
            {8, 15, 50},
            {7, 10, 25},
            {5, 8, 15},
            {4, 7, 12},
            {4, 7, 12},
            {3, 5, 8},
            {2, 3, 5},
            {2, 3, 5},
            {2, 3, 5},
            {1, 2, 4},
            {80, 160, 960}
    };

    public PrimalHuntWin(int line, int symbolId, int countOfSymbols) {
        super(line, symbolId, countOfSymbols);
        if (symbolId == 0) payout = PAYOUTS[symbolId][countOfSymbols-2];
        else
            payout = symbolId == 14 ? PAYOUTS[PAYOUTS.length-1][countOfSymbols-3] : PAYOUTS[symbolId][countOfSymbols-3];
    }

    public PrimalHuntWin(int line, int symbolId, int countOfSymbols, int multiplier) {
        this(line, symbolId, countOfSymbols);
        this.isMultiplierLine = true;
        this.multiplier = multiplier;
        payout *= multiplier;
    }

    @Override
    public String toString() {
        if (!isMultiplierLine) {
            if (line == -1) return String.format(Locale.ENGLISH, "Scatter Win: %dx scatters cost %d credits;", countOfSymbols, payout);
            return String.format(Locale.ENGLISH, "line %d: %dx %s symbol cost %d credits;", line, countOfSymbols, PrimalHuntSymbols.values()[symbolId].toString(), payout);
        }
        else {
            String result = "line %d: %d (multiplier) * %d (%dx %s symbol) = %d credits;";
            return String.format(Locale.ENGLISH, result, line, multiplier, payout/multiplier, countOfSymbols, PrimalHuntSymbols.values()[symbolId].toString(), payout);
        }
    }

    public boolean isMultiplierLine() {
        return isMultiplierLine;
    }

    public int getMultiplier() {
        return multiplier;
    }

}