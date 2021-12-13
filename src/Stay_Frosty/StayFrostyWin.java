package Stay_Frosty;

import abstractClasses.Symbols;
import abstractClasses.Win;

public class StayFrostyWin extends Win {
    public StayFrostyWin(int line, int symbolId, int countOfSymbols) {
        super(line, symbolId, countOfSymbols);
        symbol = Symbols.getById(symbolId, StayFrostySymbols.values());
        payout = symbol.getPayout(countOfSymbols);
    }
}
