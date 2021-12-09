package takesantasshop;

import abstractClasses.Solution;

import java.util.*;

public class TakeSantaSolution extends Solution {
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
        Solution solution = new TakeSantaSolution(10, 1.50, 20, "2,2,2,2|2,2,2,9|10,2,2,2|12,9,0,0|12,3,3,11", "17,18,0,1,2,3", true);
        solution.showMessage();
    }

    private void resetStopReel() {
        List<Integer> bombs = getBombs();

        String[] s = stopReel.split("[,|]");
        int counter = 0;
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length; i++) {
            if (s[i].equals("0") || bombs.contains(i))
                s[i] = "1";

            counter++;
            if (counter == 4) {
                counter = 0;
                result.append(s[i]).append("|");
            } else result.append(s[i]).append(",");
        }

        stopReel = result.toString();
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