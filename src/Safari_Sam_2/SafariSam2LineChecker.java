package Safari_Sam_2;

import abstractClasses.AbstractLineChecker;
import abstractClasses.LineChecker;
import abstractClasses.Win;

import java.util.Collections;

public class SafariSam2LineChecker extends AbstractLineChecker implements LineChecker {

    static {
        ids = SafariSam2Symbol.IDS;
        lines = SafariSam2Lines.get();
        hasMultipliers = false;
        wildIds = Collections.singletonList(10);
        isTwoSides = false;
    }

    @Override
    protected Win createWin(int line, int symbolId, int countOfSymbols, int multiplier) {
        return new SafariSam2Win(line, symbolId, countOfSymbols);
    }

}
