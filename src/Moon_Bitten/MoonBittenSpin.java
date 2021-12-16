package Moon_Bitten;

import abstractClasses.Spin;
import abstractClasses.Win;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class MoonBittenSpin extends Spin {
    private static final int BET = 150;

    public MoonBittenSpin(int spin, double coin, int bet, String stopReel) {
        super(spin, coin, bet, stopReel);
        initWins(new MoonBittenLineChecker(this));
        removeDuplicateLines();
    }

    public static void main(String[] args) {
        Spin spin = new MoonBittenSpin(92, 0.04, BET, "4,9,10|5,5,15|8,5,15|10,5,16|5,5,16|9,10,4");
        spin.showMessage();
    }
}
