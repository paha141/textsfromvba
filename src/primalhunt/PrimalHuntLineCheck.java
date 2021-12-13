package primalhunt;

import abstractClasses.AbstractLineCheck;
import abstractClasses.Win;
import abstractClasses.LineCheck;

import java.util.ArrayList;
import java.util.List;

public class PrimalHuntLineCheck extends AbstractLineCheck implements LineCheck {

    static {
        ids = PrimalHuntSymbols.IDS;
        lines = PrimalHuntLines.get();
        hasMultipliers = true;
        wildIds = new ArrayList<>(List.of(11, 12, 13));
        isTwoSides = false;
    }

    @Override
    protected Win createWin(int line, int symbolId, int countOfSymbols, int multiplier) {
        return new PrimalHuntWin(line, symbolId, countOfSymbols, multiplier);
    }
}