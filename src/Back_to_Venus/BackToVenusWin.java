package Back_to_Venus;

import abstractClasses.Symbols;
import abstractClasses.Win;

public class BackToVenusWin extends Win {

    public BackToVenusWin(int line, int symbolId, int countOfSymbols, int multiplier) {
        super(line, symbolId, countOfSymbols, multiplier);
        symbol = Symbols.getById(symbolId, BackToVenusSymbols.values());
        payout = symbol.getPayout(countOfSymbols) * multiplier;
    }
}