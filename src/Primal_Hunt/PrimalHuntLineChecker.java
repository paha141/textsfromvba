package Primal_Hunt;

import abstractClasses.AbstractLineChecker;
import abstractClasses.Win;
import abstractClasses.LineChecker;

import java.util.Arrays;

public class PrimalHuntLineChecker extends AbstractLineChecker implements LineChecker {

    static {
        ids = PrimalHuntSymbol.IDS;
        lines = PrimalHuntLines.get();
        hasMultipliers = true;
        wildIds = Arrays.asList(11, 12, 13);
        isTwoSides = false;
    }

    @Override
    protected Win createWin(int line, int symbolId, int countOfSymbols, int multiplier) {
        return new PrimalHuntWin(line, symbolId, countOfSymbols, multiplier);
    }
}