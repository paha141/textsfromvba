package abstractClasses;

import java.util.*;
import java.util.stream.Collectors;

public abstract class LineChecker implements Checker {
    protected Collection<Integer> ids;
    protected Lines lines;
    protected boolean hasMultipliers = false;
    protected Collection<Integer> wildIds;
    protected boolean isTwoSides = false;
    protected int scatterId = -1000;

    private final Spin spin;
    private final int[][] matrix;

    public LineChecker(Spin spin) {
        this.spin = spin;
        matrix = Checker.getMatrix(spin.getStopReel());
    }

    public void getWins() {
        List<Win> wins = new ArrayList<>();

        for (int i = 0; i < lines.getLines().length; i++) {
            int[] temp = new int[lines.getLines()[0].length];
            for (int j = 0; j < temp.length; j++)
                temp[j] = matrix[j][lines.getLines()[i][j]];

            wins.add(getPerLine(i + 1, temp));
            if (isTwoSides) wins.add(getPerLineReverse(i + 1, temp));
        }

        if (scatterId != -1000) wins.add(getScatterWin());

        spin.setWins(wins.stream()
                .filter(win -> win != null && win.getPayout() != 0)
                .sorted(Comparator.comparingInt(Win::getLine))
                .collect(Collectors.toList()));
    }

    private Win getPerLineReverse(int line, int[] temp) {
        return getPerLine(line, LineChecker.getReverse(temp));
    }

    private Win getPerLine(int line, int[] temp) {
        int symbolId = getSymbolId(temp, wildIds, ids);
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

    protected abstract Win createWin(int line, int symbolId, int countOfSymbols, int multiplier);

    protected static int getSymbolId(int[] temp, Collection<Integer> wildIds, Collection<Integer> ids) {
        int symbolId = Collections.min(wildIds);
        for (int i : temp) {
            if (ids.contains(i) && !wildIds.contains(i)) {
                symbolId = i;
                break;
            }
        }
        return symbolId;
    }

    private Win getScatterWin() {
        int count = getCountOfScatter();
        if (count == 0) return null;
        return createWin(-1, scatterId, count, 1);
    }

    private int getCountOfScatter() {
        return (int) Arrays.stream(spin.getStopReel().split("[,|]"))
                .filter(s -> s.equals(String.valueOf(scatterId)))
                .count();
    }

    protected static int[] getReverse(int[] arr) {
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++)
            result[i] = arr[arr.length - i - 1];

        return result;
    }

    public Spin getSpin() {
        return spin;
    }

    public int[][] getMatrix() {
        return matrix;
    }
}
