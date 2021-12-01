package takesantasshop;

import abstractClasses.Solution;

import java.util.*;

public class TakeSantaSolution extends Solution {
    //public static final double[] COIN_LEVEL = new double[] {0.01, 0.03, 0.05, 0.07, 0.1, 0.2, 0.35, 0.5, 0.65, 0.75, 1.0};
    private String currentWildPositions;

    public TakeSantaSolution(int spin, double coin, int bet, String stopReel) {
        this(spin, coin, bet, stopReel, "", false);
    }

    public TakeSantaSolution(int spin, double coin, int bet, String stopReel, String currentWildPositions, boolean isBombCounterZero) {
        super(spin, coin, bet, stopReel);
        this.currentWildPositions = currentWildPositions;
        if (isBombCounterZero)
            resetStopReel();

        wins = initWins(new TakeSantaLineCheck());
        totalWin = calcTotalWin();
    }

    public static void main(String[] args) {
        Solution solution = new TakeSantaSolution(14, 3.00, 20, "11,13,5,9|13,3,2,0|8,11,6,5|6,6,6,8|2,2,11,3", "3,9,10,11,16,0,1,2,12,4,5,6,8,13", true);
        solution.showMessage();
    }

    private void resetStopReel() {
        List<Integer> bombs = getBombs();

        String[] s = stopReel.split(",|\\|");
        int counter = 0;
        String result = "";

        for (int i = 0; i < s.length; i++) {
            if (s[i].equals("0") || bombs.contains(i))
                s[i] = "1";

            counter++;
            if (counter == 4) {
                counter = 0;
                result += s[i] + "|";
            } else result += s[i] + ",";
        }

        stopReel = result;
    }

    private List<Integer> getBombs() {
        List<Integer> result = new ArrayList<>();

        for (String s: currentWildPositions.split(","))
            result.add(Integer.parseInt(s));

        return result;
    }

    public String getCurrentWildPositions() {
        return currentWildPositions;
    }
}