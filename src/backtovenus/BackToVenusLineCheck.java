package backtovenus;

import abstractClasses.AbstractLineCheck;
import abstractClasses.Win;
import abstractClasses.LineCheck;

import java.util.*;

public class BackToVenusLineCheck extends AbstractLineCheck implements LineCheck {
    static {
        ids = BackToVenusSymbols.IDS;
        lines = BackToVenusLines.get();
        hasMultipliers = true;
        wildIds = new ArrayList<>(List.of(21, 22, 23));
        isTwoSides = false;
    }

    @Override
    protected Win createWin(int line, int symbolId, int countOfSymbols, int multiplier) {
        return new BackToVenusWin(line, symbolId, countOfSymbols, multiplier);
    }
}