package Back_to_Venus;

import abstractClasses.Symbol;
import abstractClasses.Win;

public class BackToVenusWin extends Win {

    public BackToVenusWin(int line, int symbolId, int countOfSymbols, int multiplier) {
        super(line, symbolId, countOfSymbols, multiplier);
        symbol = Symbol.getById(symbolId, BackToVenusSymbol.values());
        payout = symbol.getPayout(countOfSymbols) * multiplier;
    }
}