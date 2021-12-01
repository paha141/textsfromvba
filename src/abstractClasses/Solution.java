package abstractClasses;

import java.util.*;

public abstract class Solution {
    protected int spin;
    protected double coin;
    protected int bet;
    protected String stopReel;

    protected List<Win> wins;
    protected int totalWin;

    public Solution(int spin, double coin, int bet, String stopReel) {
        this.spin = spin;
        this.coin = coin;
        this.bet = bet;
        this.stopReel = stopReel;
    }

    protected static List<String> group(List<Win> list) {
        List<String> result = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();
        for (Win win : list) {
            String[] s = win.toString().split(":", 2);
            if (map.containsKey(s[1])) {
                String newStr = map.get(s[1]) + ", " + win.getLine();
                map.put(s[1], newStr);
            } else
                map.put(s[1], s[0]);
        }

        for (Map.Entry entry: map.entrySet())
            result.add(entry.getValue() + ":" + entry.getKey());
        Collections.sort(result);
        return result;
    }

    protected int calcTotalWin() {
        int result = 0;
        for (Win win: wins)
            result += win.getPayout();

        return result;
    }

    protected int[][] getMatrix() {
        String[] lines = stopReel.split("\\|");
        int y = lines[0].split(",").length;
        int x = lines.length;
        int[][] result = new int[x][y];
        for (int i = 0; i < result.length; i++) {
            String[] digits = lines[i].split(",");
            for (int j = 0; j < result[i].length; j++)
                result[i][j] = Integer.parseInt(digits[j]);
        }

        return result;
    }

    protected List<Win> initWins(LineCheck lineCheck) {
        return lineCheck.getWins(getMatrix());
    }

    protected List<Win> initWins(ClusterCheck clusterCheck) {
        return clusterCheck.getWins(getMatrix());
    }

    public void showMessage() {
        StringJoiner joiner = new StringJoiner("+");
        List<String> tmp = group(wins);

        System.out.printf(Locale.ENGLISH, "For spin %d (bet %d, coin %.2f):\n", spin, bet, coin);

        for (String str: tmp) {
            String[] s = str.split(" ");
            int d = Integer.parseInt(s[s.length - 2]);
            int mul = str.split(",").length;
            if (mul > 1)
                joiner.add(String.format(Locale.ENGLISH, "%d*%d", d, mul));
            else joiner.add(String.format(Locale.ENGLISH, "%d", d));
            System.out.println(str);
        }

        System.out.printf(Locale.ENGLISH, "Total for spin: %s = %d credits;\n", joiner.toString(), totalWin);
        System.out.println(getCurrencyWin());
    }

    protected String getCurrencyWin() {
        if (coin == 1)
            return "Win in currency = win in credits;";
        else return String.format(Locale.ENGLISH, "Win in currency: %d * %.2f = %.2f;", totalWin, coin, totalWin * coin);
    }

    protected void printMatrix() {
        int[][] arr = getMatrix();
        for (int i = 0; i < arr[0].length; i++) {
            for (int[] ints : arr) {
                System.out.print(ints[i] + " \t");
            }
            System.out.println();
        }
    }

    public int getSpin() {
        return spin;
    }

    public double getCoin() {
        return coin;
    }

    public int getBet() {
        return bet;
    }

    public String getStopReel() {
        return stopReel;
    }

    public List<Win> getWins() {
        return wins;
    }

    public double getTotalWin() {
        return totalWin;
    }
}