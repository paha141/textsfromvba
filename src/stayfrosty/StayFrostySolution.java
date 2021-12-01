package stayfrosty;

import abstractClasses.Solution;


public class StayFrostySolution extends Solution {
    public StayFrostySolution(int spin, double coin, int bet, String stopReel) {
        super(spin, coin, bet, stopReel);

        wins = initWins(new StayFrostyLineCheck());
        totalWin = calcTotalWin();
    }

    public static void main(String[] args) {
        Solution solution = new StayFrostySolution(173, 4.00, 25, "7,6,6,6|0,0,0,0|4,0,0,0|7,7,7,8|8,8,8,10");
        solution.showMessage();
    }

}
