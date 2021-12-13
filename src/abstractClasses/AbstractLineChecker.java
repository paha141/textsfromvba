package abstractClasses;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class AbstractLineChecker implements LineChecker {
    protected static Set<Integer> ids;
    protected static Lines lines;
    protected static boolean hasMultipliers = false;
    protected static List<Integer> wildIds;
    protected static boolean isTwoSides = false;

    @Override
    public List<Win> getWins(int[][] matrix) {
        List<Win> result = new ArrayList<>();

        for (int i = 0; i < lines.getLines().length; i++) {
            int[] temp = new int[lines.getLines()[0].length];
            for (int j = 0; j < temp.length; j++)
                temp[j] = matrix[j][lines.getLines()[i][j]];

            if (hasMultipliers)
                result.add(checkLineWithMultiplier(i + 1, temp, getSymbolId(temp)));
            else if (isTwoSides) {
                result.add(checkLine(i + 1, temp, getSymbolId(temp)));
                int[] reverse = LineChecker.getReverse(temp);
                result.add(checkLine(i + 1, reverse, getSymbolId(reverse)));
            } else result.add(checkLine(i + 1, temp, getSymbolId(temp)));

        }

        return result.stream()
                .filter(win -> win.getPayout() != 0)
                .sorted(Comparator.comparingInt(Win::getLine))
                .collect(Collectors.toList());
    }

    protected Win checkLineWithMultiplier(int line, int[] temp, int symbolId) {
        int count = 0;
        int multiplier = 1;

        for (int i : temp) {
            if (wildIds.contains(i)) {
                multiplier *= i - wildIds.get(0) + 1;
                count++;
                continue;
            }
            if (i == symbolId) count++;
            else break;
        }

        return createWin(line, symbolId, count, multiplier);
    }

    protected Win checkLine(int line, int[] temp, int symbolId) {
        int count = 0;

        for (int i : temp) {
            if (wildIds.contains(i) || i == symbolId) count++;
            else break;
        }

        return createWin(line, symbolId, count, 1);
    }

    protected abstract Win createWin(int line, int symbolId, int countOfSymbols, int multiplier);

    protected int getSymbolId(int[] temp) {
        int symbolId = wildIds.get(0);
        for (int i : temp) {
            if (ids.contains(i) && !wildIds.contains(i)) {
                symbolId = i;
                break;
            }
        }
        return symbolId;
    }
}
