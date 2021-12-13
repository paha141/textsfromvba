package Take_Santas_Shop;

import abstractClasses.Symbol;
import abstractClasses.Win;

public class TakeSantaWin extends Win {
    public TakeSantaWin(int line, int symbolId, int countOfSymbols) {
        super(line, symbolId, countOfSymbols);
        symbol = Symbol.getById(symbolId, TakeSantaSymbol.values());
        payout = symbol.getPayout(countOfSymbols);
    }
}