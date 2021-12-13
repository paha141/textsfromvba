package Stay_Frosty;

import abstractClasses.Symbol;
import abstractClasses.Win;

public class StayFrostyWin extends Win {
    public StayFrostyWin(int line, int symbolId, int countOfSymbols) {
        super(line, symbolId, countOfSymbols);
        symbol = Symbol.getById(symbolId, StayFrostySymbol.values());
        payout = symbol.getPayout(countOfSymbols);
    }
}
