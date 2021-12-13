package Back_to_Venus;

import abstractClasses.AbstractLineChecker;
import abstractClasses.Win;
import abstractClasses.LineChecker;

import java.util.Arrays;


public class BackToVenusLineChecker extends AbstractLineChecker implements LineChecker {
    static {
        ids = BackToVenusSymbol.IDS;
        lines = BackToVenusLines.get();
        hasMultipliers = true;
        wildIds = Arrays.asList(21, 22, 23);
        isTwoSides = false;
    }

    @Override
    protected Win createWin(int line, int symbolId, int countOfSymbols, int multiplier) {
        return new BackToVenusWin(line, symbolId, countOfSymbols, multiplier);
    }
}