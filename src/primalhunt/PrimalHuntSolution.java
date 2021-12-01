package primalhunt;

import abstractClasses.Solution;

public class PrimalHuntSolution extends Solution {
    public PrimalHuntSolution(int spin, double coin, int bet, String stopReel) {
        super(spin, coin, bet, stopReel);

        wins = initWins(new PrimalHuntLineCheck());
        checkScatterWin();
        totalWin = calcTotalWin();
    }

    public static void main(String[] args) {
        Solution solution = new PrimalHuntSolution(427, 2.20, 10, "8,8,8,10|12,10,10,10|12,12,12,12|3,3,7,7|10,10,10,0");
        solution.showMessage();
    }

    private void checkScatterWin() {
        int count = 0;
        for (String s: stopReel.split(",|\\|")) {
            if (s.equals("14"))
                count++;
        }

        if (count >= 3)
            wins.add(new PrimalHuntWin(-1, 14, count));
    }
}