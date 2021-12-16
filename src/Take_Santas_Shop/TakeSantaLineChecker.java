package Take_Santas_Shop;

import abstractClasses.LineChecker;
import abstractClasses.Spin;
import abstractClasses.Win;

import java.util.Collections;


public class TakeSantaLineChecker extends LineChecker {

    {
        ids = TakeSantaSymbol.IDS;
        lines = TakeSantaLines.get();
        hasMultipliers = false;
        wildIds = Collections.singletonList(TakeSantaSymbol.WILD.getId());
        isTwoSides = false;
    }

    public TakeSantaLineChecker(Spin spin) {
        super(spin);
    }

    @Override
    protected Win createWin(int line, int symbolId, int countOfSymbols, int multiplier) {
        return new TakeSantaWin(line, symbolId, countOfSymbols);
    }
}