package Primal_Hunt;

import abstractClasses.LineChecker;
import abstractClasses.Spin;
import abstractClasses.Win;

import java.util.Arrays;

public class PrimalHuntLineChecker extends LineChecker {

    {
        ids = PrimalHuntSymbol.IDS;
        lines = PrimalHuntLines.get();
        hasMultipliers = true;
        wildIds = Arrays.asList(11, 12, 13);
        isTwoSides = false;
        scatterId = PrimalHuntSymbol.SCATTER.getId();
    }

    public PrimalHuntLineChecker(Spin spin) {
        super(spin);
    }

    @Override
    protected Win createWin(int line, int symbolId, int countOfSymbols, int multiplier) {
        return new PrimalHuntWin(line, symbolId, countOfSymbols, multiplier);
    }
}