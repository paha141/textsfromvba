package Primal_Hunt;

import abstractClasses.LineChecker;
import abstractClasses.Spin;

public class PrimalHuntSpin extends Spin {
    private static final int BET = 10;
    private static final LineChecker LINE_CHECKER = new LineChecker(
            PrimalHuntSymbol.class,
            PrimalHuntLines.get(),
            PrimalHuntSymbol.WILD_IDS,
            true, false,
            PrimalHuntSymbol.SCATTER.getId()
    );

    public PrimalHuntSpin(int spin, double coin, int bet, String stopReel) {
        super(LINE_CHECKER, spin, coin, bet, stopReel);
        initLineWins();
    }

    public static void main(String[] args) {
        Spin spin = new PrimalHuntSpin(427, 2.20, BET, "8,8,8,10|12,10,10,10|12,12,12,12|3,3,7,7|10,10,10,0");
        spin.showMessage();
    }

}