package Take_Santas_Shop;

import abstractClasses.AbstractLineChecker;
import abstractClasses.Win;
import abstractClasses.LineChecker;

import java.util.Collections;


public class TakeSantaLineChecker extends AbstractLineChecker implements LineChecker {

    static {
        ids = TakeSantaSymbol.IDS;
        lines = TakeSantaLines.get();
        hasMultipliers = false;
        wildIds = Collections.singletonList(1);
        isTwoSides = false;
    }

    @Override
    protected Win createWin(int line, int symbolId, int countOfSymbols, int multiplier) {
        return new TakeSantaWin(line, symbolId, countOfSymbols);
    }
}