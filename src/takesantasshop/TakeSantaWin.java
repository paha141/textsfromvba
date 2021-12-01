package takesantasshop;

import abstractClasses.Win;

import java.util.Locale;

public class TakeSantaWin extends Win {
    private static final int[][] PAYOUTS = new int[][] {
            {1, 4, 12, 60},
            {3, 6, 20},
            {3, 5, 18},
            {2, 4, 12},
            {2, 4, 12},
            {2, 4, 12},
            {2, 4, 12},
            {1, 2, 6},
            {1, 2, 6},
            {1, 2, 6},
            {1, 2, 6},
            {1, 2, 6},
    };

    public TakeSantaWin(int line, int symbolId, int countOfSymbols) {
        super(line, symbolId, countOfSymbols);
        if (symbolId == 2) payout = PAYOUTS[symbolId-2][countOfSymbols-2];
        else payout = PAYOUTS[symbolId-2][countOfSymbols-3];
    }

    @Override
    public String toString() {
        return String.format(Locale.ENGLISH, "line %d: %dx %s symbol cost %d credits;", line, countOfSymbols, TakeSantaSymbols.values()[symbolId - 2].toString(), payout);
    }
}