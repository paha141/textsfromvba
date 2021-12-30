package Moon_Bitten;

import abstractClasses.*;

import java.util.*;

public class MoonBittenLineChecker extends LineChecker {

    public MoonBittenLineChecker(Class<? extends Symbol> symbolClass, Lines lines, Collection<Integer> wildIds, boolean hasMultipliers, boolean isTwoSides, int scatterId) {
        super(symbolClass, lines, wildIds, hasMultipliers, isTwoSides, scatterId);
    }

    @Override
    protected Win checkLine(int line, int[] temp, int symbolId) {
        int count = 0;
        symbolId = symbolId == MoonBittenSymbol.TWO_BATS.getId() ? MoonBittenSymbol.BAT.getId() : symbolId;
        for (int i : temp) {
            if (i == symbolId || getWildIds().contains(i))
                count++;
            else if (i == MoonBittenSymbol.TWO_BATS.getId() && symbolId == MoonBittenSymbol.BAT.getId()) {
                count += 2;
            } else break;
        }
        return biggerWin(line, temp, createWin(line, symbolId, count, 1));
    }

    private Win biggerWin(int line, int[] temp, Win win) {
        int count = 0;
        for (int i : temp) {
            if (getWildIds().contains(i))
                count++;
            else {
                if (count < 3) return win;
                break;
            }
        }

        Win winWild = createWin(line, MoonBittenSymbol.WILD.getId(), count, 1);
        return winWild.compareTo(win) > 0 ? winWild : win;
    }
}
