package stayfrosty;

import abstractClasses.Win;

import java.util.Locale;

public class StayFrostyWin extends Win {
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
            {125, 250, 1250}
    };

    public StayFrostyWin(int line, int symbolId, int countOfSymbols) {
        super(line, symbolId, countOfSymbols);
        if (symbolId == 1) payout = PAYOUTS[symbolId-1][countOfSymbols-2];
        else
            payout = symbolId == 12 ? PAYOUTS[PAYOUTS.length-1][countOfSymbols-3] : PAYOUTS[symbolId-1][countOfSymbols-3];
    }

    @Override
    public String toString() {
        return String.format(Locale.ENGLISH, "line %d: %dx %s symbol cost %d credits;", line, countOfSymbols, StayFrostySymbols.values()[symbolId-1].toString(), payout);
    }
}
