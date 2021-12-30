package abstractClasses;

import java.util.*;
import java.util.stream.Collectors;

public class LineChecker implements Checker {
    private final Class<? extends Symbol> symbolClass;
    private final Lines lines;
    private final Collection<Integer> wildIds;
    private final Collection<Integer> ids;
    private boolean hasMultipliers;
    private boolean isTwoSides;
    private int scatterId;


    public LineChecker(Class<? extends Symbol> symbolClass, Lines lines, Collection<Integer> wildIds, boolean hasMultipliers, boolean isTwoSides, int scatterId) {
        this.symbolClass = symbolClass;
        this.lines = lines;
        this.wildIds = wildIds;
        this.hasMultipliers = hasMultipliers;
        this.isTwoSides = isTwoSides;
        this.scatterId = scatterId;
        this.ids = Symbol.getIds(symbolClass.getEnumConstants());
    }

    @Override
    public List<Win> initWins(String stopReel) {
        int[][] matrix = Checker.getMatrix(stopReel);
        List<Win> wins = new ArrayList<>();
        for (int i = 0; i < lines.getLines().length; i++) {
            int[] temp = new int[lines.getLines()[0].length];
            for (int j = 0; j < temp.length; j++) {
                temp[j] = matrix[j][lines.getLines()[i][j]];
            }
            wins.add(getPerLine(i + 1, temp));
            if (isTwoSides) wins.add(getPerLineReverse(i + 1, temp));
        }
        if (scatterId != -1000) wins.add(getScatterWin(stopReel));
        return wins.stream()
                .filter(win -> win != null && win.getPayout() != 0)
                .sorted(Comparator.comparingInt(Win::getLine))
                .collect(Collectors.toList());
    }

    private Win getPerLineReverse(int line, int[] temp) {
        return getPerLine(line, LineChecker.getReverse(temp));
    }

    private Win getPerLine(int line, int[] temp) {
        int symbolId = getSymbolIdForLine(temp, wildIds, ids);
        if (symbolId == scatterId) return null;
        return hasMultipliers ? checkLineWithMultiplier(line, temp, symbolId) : checkLine(line, temp, symbolId);
    }

    protected Win checkLineWithMultiplier(int line, int[] temp, int symbolId) {
        int count = 0;
        int multiplier = 1;
        for (int i : temp) {
            if (wildIds.contains(i)) {
                multiplier *= i - Collections.min(wildIds) + 1;
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

    protected final Win createWin(int line, int symbolId, int countOfSymbols) {
        return new Win(line, getSymbolByClass(symbolId), countOfSymbols);
    }

    protected final Win createWin(int line, int symbolId, int countOfSymbols, int multiplier) {
        return new Win(line, getSymbolByClass(symbolId), countOfSymbols, multiplier);
    }

    private Symbol getSymbolByClass(int symbolId) {
        return Symbol.getById(symbolId, symbolClass.getEnumConstants());
    }

    private Win getScatterWin(String stopReel) {
        int count = getCountOfScatter(stopReel);
        if (count == 0) return null;
        return createWin(-1, scatterId, count, 1);
    }

    private int getCountOfScatter(String stopReel) {
        return (int) Arrays.stream(stopReel.split("[,|]"))
                .filter(s -> s.equals(String.valueOf(scatterId)))
                .count();
    }

    protected static int getSymbolIdForLine(int[] temp, Collection<Integer> wildIds, Collection<Integer> ids) {
        int symbolId = Collections.min(wildIds);
        for (int i : temp) {
            if (ids.contains(i) && !wildIds.contains(i)) {
                symbolId = i;
                break;
            }
        }
        return symbolId;
    }

    protected static int[] getReverse(int[] arr) {
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[arr.length - i - 1];
        }
        return result;
    }

    public Class<? extends Symbol> getSymbolClass() {
        return symbolClass;
    }

    public Lines getLines() {
        return lines;
    }

    public Collection<Integer> getWildIds() {
        return wildIds;
    }

    public Collection<Integer> getIds() {
        return ids;
    }

    public boolean isHasMultipliers() {
        return hasMultipliers;
    }

    public void setHasMultipliers(boolean hasMultipliers) {
        this.hasMultipliers = hasMultipliers;
    }

    public boolean isTwoSides() {
        return isTwoSides;
    }

    public void setTwoSides(boolean twoSides) {
        isTwoSides = twoSides;
    }

    public int getScatterId() {
        return scatterId;
    }

    public void setScatterId(int scatterId) {
        this.scatterId = scatterId;
    }
}
