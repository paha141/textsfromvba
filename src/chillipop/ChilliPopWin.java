package chillipop;

import abstractClasses.Win;

import java.util.Arrays;
import java.util.Locale;

public class ChilliPopWin extends Win {
    private int countOfWilds;

    private static final int[] PAYOUTS = new int[] {12, 12, 7, 6, 5, 2, 2, 2};
    private static final int[] WILD_COUNTS = new int[] {15, 20, 24, 30, 36, 42, 48, 56, 64};
    private static final int[] WILD_PAYOUTS = new int[] {2500, 3750, 5000, 10000, 15000, 20000, 30000, 40000, 50000};

    public ChilliPopWin(int line, int symbolId, int countOfSymbols) {
        super(line, symbolId, countOfSymbols);
        if (symbolId == 8) {
            int index = Arrays.binarySearch(WILD_COUNTS, countOfSymbols);
            payout = WILD_PAYOUTS[index];
        }
        else payout = PAYOUTS[symbolId]*countOfSymbols;
    }

    public ChilliPopWin(int line, int symbolId, int countOfSymbols, int countOfWilds) {
        this(line, symbolId, countOfSymbols);
        this.countOfWilds = countOfWilds;
        payout *= countOfWilds;
    }

    @Override
    public String toString() {
        if (countOfWilds > 0) {
            String result = "chain %d: %d (count of Wilds + 1) * %d (cost %s symbol) * %d (count of symbols) = %d credits;";
            return String.format(Locale.ENGLISH, result, line, countOfWilds, payout / countOfWilds / countOfSymbols, ChilliPopSymbols.values()[symbolId].toString(), countOfSymbols, payout);
        } else return String.format(Locale.ENGLISH, "chain %d: %dx %s cost %d credits;", line, countOfSymbols, ChilliPopSymbols.values()[symbolId].toString(), payout);
    }

    public int getCountOfWilds() {
        return countOfWilds;
    }
}