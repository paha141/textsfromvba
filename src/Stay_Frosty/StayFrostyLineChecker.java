package Stay_Frosty;

import abstractClasses.LineChecker;
import abstractClasses.Spin;
import abstractClasses.Win;

import java.util.Collections;

public class StayFrostyLineChecker extends LineChecker {

    {
        ids = StayFrostySymbol.IDS;
        lines = StayFrostyLines.get();
        hasMultipliers = false;
        wildIds = Collections.singletonList(0);
        isTwoSides = false;
        scatterId = StayFrostySymbol.SCATTER.getId();
    }

    public StayFrostyLineChecker(Spin spin) {
        super(spin);
    }

    @Override
    protected Win createWin(int line, int symbolId, int countOfSymbols, int multiplier) {
        return new StayFrostyWin(line, symbolId, countOfSymbols);
    }
}
