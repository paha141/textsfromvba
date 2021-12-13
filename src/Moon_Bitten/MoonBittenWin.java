package Moon_Bitten;

import abstractClasses.Symbol;
import abstractClasses.Win;

public class MoonBittenWin extends Win {

    public MoonBittenWin(int line, int symbolId, int countOfSymbols) {
        super(line, symbolId, countOfSymbols);
        symbol = Symbol.getById(symbolId, MoonBittenSymbol.values());
        payout = symbol.getPayout(countOfSymbols);
    }
}
