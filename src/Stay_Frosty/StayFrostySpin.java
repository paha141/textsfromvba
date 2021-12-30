package Stay_Frosty;

import abstractClasses.LineChecker;
import abstractClasses.Spin;


public class StayFrostySpin extends Spin {
    private static final LineChecker LINE_CHECKER = new LineChecker(
            StayFrostySymbol.class,
            StayFrostyLines.get(),
            StayFrostySymbol.WILD_IDS,
            false, false,
            StayFrostySymbol.SCATTER.getId()
    );

    public StayFrostySpin(int spin, double coin, int bet, String stopReel) {
        super(LINE_CHECKER, spin, coin, bet, stopReel);
        initLineWins();
    }

    public static void main(String[] args) {
        Spin spin = new StayFrostySpin(173, 0.08, 25, "2,7,12,7|12,5,4,7|12,6,8,1|12,11,7,9|11,12,5,5");
        spin.showMessage();
    }
}
