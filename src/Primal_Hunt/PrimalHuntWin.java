package Primal_Hunt;

import abstractClasses.Symbol;
import abstractClasses.Win;

public class PrimalHuntWin extends Win {

    public PrimalHuntWin(int line, int symbolId, int countOfSymbols) {
        this(line, symbolId, countOfSymbols, 1);
    }

    public PrimalHuntWin(int line, int symbolId, int countOfSymbols, int multiplier) {
        super(line, symbolId, countOfSymbols, multiplier);
        symbol = Symbol.getById(symbolId, PrimalHuntSymbol.values());
        payout = symbol.getPayout(countOfSymbols) * multiplier;
    }

}