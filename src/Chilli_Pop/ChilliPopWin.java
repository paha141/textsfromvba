package Chilli_Pop;

import abstractClasses.Symbols;
import abstractClasses.Win;

import java.util.Arrays;

public class ChilliPopWin extends Win {

    private static final int[] WILD_COUNTS = new int[]{15, 20, 24, 30, 36, 42, 48, 56, 64};
    private static final int[] WILD_PAYOUTS = new int[]{2500, 3750, 5000, 10000, 15000, 20000, 30000, 40000, 50000};

    public ChilliPopWin(int line, int symbolId, int countOfSymbols) {
        this(line, symbolId, countOfSymbols, 1);
    }

    public ChilliPopWin(int line, int symbolId, int countOfSymbols, int multiplier) {
        super(line, symbolId, countOfSymbols, multiplier);
        symbol = Symbols.getById(symbolId, ChilliPopSymbols.values());
        if (symbolId == ChilliPopSymbols.WILD.getId()) {
            int index = Arrays.binarySearch(WILD_COUNTS, countOfSymbols);
            payout = WILD_PAYOUTS[index];
        } else payout = symbol.getPayout(countOfSymbols) * multiplier;
    }
}