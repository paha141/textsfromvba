package Moon_Bitten;

import abstractClasses.LineChecker;
import abstractClasses.Spin;

public class MoonBittenSpin extends Spin {
    private static final int BET = 150;
    private static final LineChecker LINE_CHECKER = new MoonBittenLineChecker(
            MoonBittenSymbol.class,
            MoonBittenLines.get(),
            MoonBittenSymbol.WILD_IDS,
            false, true,
            -1000
    );

    public MoonBittenSpin(int spin, double coin, int bet, String stopReel) {
        super(LINE_CHECKER, spin, coin, bet, stopReel);
        initLineWins();
        removeDuplicateLines();
    }

    public static void main(String[] args) {
        Spin spin = new MoonBittenSpin(92, 0.04, BET, "4,9,10|5,5,15|8,5,15|10,5,16|5,5,16|9,10,4");
        spin.showMessage();
    }
}
