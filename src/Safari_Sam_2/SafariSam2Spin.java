package Safari_Sam_2;

import abstractClasses.LineChecker;
import abstractClasses.Spin;

public class SafariSam2Spin extends Spin {
    private static final int BET = 20;
    private static final LineChecker LINE_CHECKER = new LineChecker(
            SafariSam2Symbol.class,
            SafariSam2Lines.get(),
            SafariSam2Symbol.WILD_IDS,
            false, false,
            SafariSam2Symbol.SCATTER.getId()
    );

    public SafariSam2Spin(int spin, double coin, int bet, String stopReel) {
        super(LINE_CHECKER, spin, coin, bet, stopReel);
        initLineWins();
    }


    public static void main(String[] args) {
        Spin spin = new SafariSam2Spin(173, 5.00, BET, "10,10,10|10,10,10|7,7,2|10,10,10|2,2,8");
        spin.showMessage();
    }

}
