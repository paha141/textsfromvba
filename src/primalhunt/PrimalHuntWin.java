package primalhunt;

import abstractClasses.Symbols;
import abstractClasses.Win;

public class PrimalHuntWin extends Win {

    public PrimalHuntWin(int line, int symbolId, int countOfSymbols) {
        this(line, symbolId, countOfSymbols, 1);
    }

    public PrimalHuntWin(int line, int symbolId, int countOfSymbols, int multiplier) {
        super(line, symbolId, countOfSymbols, multiplier);
        symbol = Symbols.getById(symbolId, PrimalHuntSymbols.values());
        payout = symbol.getPayout(countOfSymbols) * multiplier;
    }

}