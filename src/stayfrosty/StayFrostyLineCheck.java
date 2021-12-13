package stayfrosty;

import abstractClasses.AbstractLineCheck;
import abstractClasses.LineCheck;
import abstractClasses.Win;

import java.util.ArrayList;
import java.util.List;

public class StayFrostyLineCheck extends AbstractLineCheck implements LineCheck {

    static {
        ids = StayFrostySymbols.IDS;
        lines = StayFrostyLines.get();
        hasMultipliers = false;
        wildIds = new ArrayList<>(List.of(0));
        isTwoSides = false;
    }

    @Override
    protected Win createWin(int line, int symbolId, int countOfSymbols, int multiplier) {
        return new StayFrostyWin(line, symbolId, countOfSymbols);
    }
}
