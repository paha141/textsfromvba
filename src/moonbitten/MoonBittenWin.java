package moonbitten;

import abstractClasses.Win;

import java.util.Locale;

public class MoonBittenWin extends Win {
    private static final int[][] PAYOUTS = new int[][] {
            {100, 200, 500, 1000, 2500, 4000, 7500, 15000, 25000, 50000},
            {75, 300, 1000, 2500},
            {60, 250, 750, 2000},
            {50, 200, 600, 1500},
            {40, 125, 375, 750},
            {40, 100, 300, 600},
            {15, 35, 75, 150},
            {15, 35, 75, 150},
            {10, 25, 50, 100},
            {10, 25, 50, 100},
            {100, 375, 1000, 3750}
    };


    public MoonBittenWin(int line, int symbolId, int countOfSymbols) {
        super(line, symbolId, countOfSymbols);
        payout = PAYOUTS[symbolId][countOfSymbols-3];
    }

    @Override
    public String toString() {
        return String.format(Locale.ENGLISH, "line %d: %dx %s symbol cost %d credits;", line, countOfSymbols, MoonBittenSymbols.values()[symbolId].toString(), payout);
    }
}
