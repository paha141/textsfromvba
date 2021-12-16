package Safari_Sam_2;

import abstractClasses.Spin;

public class SafariSam2Spin extends Spin {
    private static final int BET = 20;

    public SafariSam2Spin(int spin, double coin, int bet, String stopReel) {
        super(spin, coin, bet, stopReel);
        initWins(new SafariSam2LineChecker(this));
    }


    public static void main(String[] args) {
        Spin spin = new SafariSam2Spin(173, 5.00, BET, "10,10,10|10,10,10|7,7,2|10,10,10|2,2,8");
        spin.showMessage();
    }

}
