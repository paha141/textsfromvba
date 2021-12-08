package safarisam2;

import abstractClasses.Win;

import java.util.Locale;

public class SafariSam2Win extends Win {
    private static final int[][] PAYOUTS = new int[][] {
            {25, 50, 200},
            {20, 40, 160},
            {15, 30, 80},
            {12, 25, 70},
            {10, 20, 60},
            {10, 20, 50},
            {7, 12, 30},
            {7, 12, 25},
            {5, 10, 25},
            {5, 10, 20},
            {25, 50, 200},
            {60, 240, 1000}
    };

    public SafariSam2Win(int line, int symbolId, int countOfSymbols) {
        super(line, symbolId, countOfSymbols);
        payout = PAYOUTS[symbolId][countOfSymbols-3];
    }

    @Override
    public String toString() {
        if (line == -1) return String.format(Locale.ENGLISH, "Scatter Win: %dx Tree cost %d credits;", countOfSymbols, payout);
        return String.format(Locale.ENGLISH, "line %d: %dx %s symbol cost %d credits;", line, countOfSymbols, SafariSam2Symbols.values()[symbolId].toString(), payout);
    }
}
