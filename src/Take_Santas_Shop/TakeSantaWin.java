package Take_Santas_Shop;

import abstractClasses.Symbols;
import abstractClasses.Win;

public class TakeSantaWin extends Win {
    public TakeSantaWin(int line, int symbolId, int countOfSymbols) {
        super(line, symbolId, countOfSymbols);
        symbol = Symbols.getById(symbolId, TakeSantaSymbols.values());
        payout = symbol.getPayout(countOfSymbols);
    }
}