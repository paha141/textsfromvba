package Safari_Sam_2;

import abstractClasses.LineChecker;
import abstractClasses.Spin;
import abstractClasses.Win;

import java.util.Collections;

public class SafariSam2LineChecker extends LineChecker {

    {
        ids = SafariSam2Symbol.IDS;
        lines = SafariSam2Lines.get();
        hasMultipliers = false;
        wildIds = Collections.singletonList(SafariSam2Symbol.WILD.getId());
        isTwoSides = false;
        scatterId = SafariSam2Symbol.SCATTER.getId();
    }

    public SafariSam2LineChecker(Spin spin) {
        super(spin);
    }

    @Override
    protected Win createWin(int line, int symbolId, int countOfSymbols, int multiplier) {
        return new SafariSam2Win(line, symbolId, countOfSymbols);
    }

}
