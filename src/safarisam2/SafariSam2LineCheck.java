package safarisam2;

import abstractClasses.AbstractLineCheck;
import abstractClasses.LineCheck;
import abstractClasses.Win;

import java.util.ArrayList;
import java.util.List;

public class SafariSam2LineCheck extends AbstractLineCheck implements LineCheck {

    static {
        ids = SafariSam2Symbols.IDS;
        lines = SafariSam2Lines.get();
        hasMultipliers = false;
        wildIds = new ArrayList<>(List.of(10));
        isTwoSides = false;
    }

    @Override
    protected Win createWin(int line, int symbolId, int countOfSymbols, int multiplier) {
        return new SafariSam2Win(line, symbolId, countOfSymbols);
    }

}
