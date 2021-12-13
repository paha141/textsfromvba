package moonbitten;

import abstractClasses.AbstractLineCheck;
import abstractClasses.LineCheck;
import abstractClasses.Win;

import java.util.*;

public class MoonBittenLineCheck extends AbstractLineCheck implements LineCheck {

    static {
        ids = MoonBittenSymbols.IDS;
        lines = MoonBittenLines.get();
        hasMultipliers = false;
        wildIds = new ArrayList<>(List.of(10, 11, 14, 15, 16));
        isTwoSides = true;
    }

    @Override
    protected Win checkLine(int line, int[] temp, int symbolId) {
        int count = 0;
        symbolId = symbolId == MoonBittenSymbols.TWO_BATS.getId() ? MoonBittenSymbols.BAT.getId() : symbolId;
        for (int i : temp) {
            if (i == symbolId || wildIds.contains(i))
                count++;
            else if (i == MoonBittenSymbols.TWO_BATS.getId() && symbolId == MoonBittenSymbols.BAT.getId()) {
                count += 2;
            } else break;
        }
        return biggerWin(line, temp, new MoonBittenWin(line, symbolId, count));
    }

    @Override
    protected Win createWin(int line, int symbolId, int countOfSymbols, int multiplier) {
        return new MoonBittenWin(line, symbolId, countOfSymbols);
    }

    private Win biggerWin(int line, int[] temp, Win win) {
        int count = 0;
        for (int i : temp) {
            if (wildIds.contains(i))
                count++;
            else {
                if (count < 3) return win;
                break;
            }
        }

        Win winWild = new MoonBittenWin(line, MoonBittenSymbols.WILD.getId(), count);
        return winWild.getPayout() > win.getPayout() ? winWild : win;
    }
}
