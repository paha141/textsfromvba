package Back_to_Venus;

import abstractClasses.LineChecker;
import abstractClasses.Spin;
import abstractClasses.Win;

import java.util.Arrays;


public class BackToVenusLineChecker extends LineChecker {
    {
        ids = BackToVenusSymbol.IDS;
        lines = BackToVenusLines.get();
        hasMultipliers = true;
        wildIds = Arrays.asList(21, 22, 23);
        isTwoSides = false;
    }

    public BackToVenusLineChecker(Spin spin) {
        super(spin);
    }

    @Override
    protected Win createWin(int line, int symbolId, int countOfSymbols, int multiplier) {
        return new BackToVenusWin(line, symbolId, countOfSymbols, multiplier);
    }
}