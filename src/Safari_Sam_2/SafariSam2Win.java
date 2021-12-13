package Safari_Sam_2;

import abstractClasses.Symbols;
import abstractClasses.Win;

public class SafariSam2Win extends Win {
    public SafariSam2Win(int line, int symbolId, int countOfSymbols) {
        super(line, symbolId, countOfSymbols);
        symbol = Symbols.getById(symbolId, SafariSam2Symbols.values());
        payout = symbol.getPayout(countOfSymbols);
    }
}
