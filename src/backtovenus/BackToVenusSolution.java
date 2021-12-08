package backtovenus;

import abstractClasses.Solution;

import java.util.*;

public class BackToVenusSolution extends Solution {

    private String multiplier;

    public BackToVenusSolution(int spin, double coin, int bet, String stopReel) {
        this(spin, coin, bet, stopReel, "");
    }

    public BackToVenusSolution(int spin, double coin, int bet, String stopReel, String multiplier) {
        super(spin, coin, bet, stopReel);
        this.multiplier = multiplier;

        if (!multiplier.isEmpty()) resetStopReel();
        wins = initWins(new BackToVenusLineCheck());
        totalWin = calcTotalWin();
    }

    public static void main(String[] args) {

        Solution solution = new BackToVenusSolution(38, 1.20, 20, "1,1,1|1,1,1|1,1,1|1,1,1|1,1,1", "");
        solution.showMessage();
    }

    private void resetStopReel() {
        Map<Integer, Integer> map = getMultipliers();

        String[] s = stopReel.split("[,|]");
        int counter = 0;
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length; i++) {
            if (s[i].equals("0") || map.containsKey(i)) {
                s[i] = "21";
                if (map.get(i) != null)
                    s[i] = map.get(i) == 2 ? "22" : "23";
            }

            counter++;
            if (counter == 3) {
                counter = 0;
                result.append(s[i]).append("|");
            } else result.append(s[i]).append(",");
        }

        stopReel = result.toString();
    }

    private Map<Integer, Integer> getMultipliers() {
        Map<Integer, Integer> result = new HashMap<>();
        String[] multipliers = multiplier.split("\\|");
        for (String s : multipliers) {
            String[] mul = s.split(":", 2);
            int index = Integer.parseInt(mul[0]);
            int value = Integer.parseInt(mul[1]);
            result.put(index, value);
        }
        return result;
    }
}