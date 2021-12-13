package Stay_Frosty;

import abstractClasses.AbstractLineChecker;
import abstractClasses.LineChecker;
import abstractClasses.Win;

import java.util.Collections;

public class StayFrostyLineChecker extends AbstractLineChecker implements LineChecker {

    static {
        ids = StayFrostySymbols.IDS;
        lines = StayFrostyLines.get();
        hasMultipliers = false;
        wildIds = Collections.singletonList(0);
        isTwoSides = false;
    }

    @Override
    protected Win createWin(int line, int symbolId, int countOfSymbols, int multiplier) {
        return new StayFrostyWin(line, symbolId, countOfSymbols);
    }
}
