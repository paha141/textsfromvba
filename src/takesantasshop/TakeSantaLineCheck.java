package takesantasshop;

import abstractClasses.AbstractLineCheck;
import abstractClasses.Win;
import abstractClasses.LineCheck;

import java.util.ArrayList;
import java.util.List;


public class TakeSantaLineCheck extends AbstractLineCheck implements LineCheck {

    static {
        ids = TakeSantaSymbols.IDS;
        lines = TakeSantaLines.get();
        hasMultipliers = false;
        wildIds = new ArrayList<>(List.of(1));
        isTwoSides = false;
    }

    @Override
    protected Win createWin(int line, int symbolId, int countOfSymbols, int multiplier) {
        return new TakeSantaWin(line, symbolId, countOfSymbols);
    }
}