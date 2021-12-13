package Safari_Sam_2;

import abstractClasses.Symbol;
import abstractClasses.Win;

public class SafariSam2Win extends Win {
    public SafariSam2Win(int line, int symbolId, int countOfSymbols) {
        super(line, symbolId, countOfSymbols);
        symbol = Symbol.getById(symbolId, SafariSam2Symbol.values());
        payout = symbol.getPayout(countOfSymbols);
    }
}
