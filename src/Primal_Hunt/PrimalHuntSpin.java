package Primal_Hunt;

import abstractClasses.Spin;

public class PrimalHuntSpin extends Spin {
    private static final int BET = 10;

    public PrimalHuntSpin(int spin, double coin, int bet, String stopReel) {
        super(spin, coin, bet, stopReel);

        initWins(new PrimalHuntLineChecker(this));
    }

    public static void main(String[] args) {
        Spin spin = new PrimalHuntSpin(427, 2.20, BET, "8,8,8,10|12,10,10,10|12,12,12,12|3,3,7,7|10,10,10,0");
        spin.showMessage();
    }

}