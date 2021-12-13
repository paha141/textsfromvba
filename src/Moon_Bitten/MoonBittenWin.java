package Moon_Bitten;

import abstractClasses.Symbols;
import abstractClasses.Win;

public class MoonBittenWin extends Win {

    public MoonBittenWin(int line, int symbolId, int countOfSymbols) {
        super(line, symbolId, countOfSymbols);
        symbol = Symbols.getById(symbolId, MoonBittenSymbols.values());
        payout = symbol.getPayout(countOfSymbols);
    }
}
