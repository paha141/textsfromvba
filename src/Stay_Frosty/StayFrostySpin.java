package Stay_Frosty;

import abstractClasses.Spin;


public class StayFrostySpin extends Spin {
    public StayFrostySpin(int spin, double coin, int bet, String stopReel) {
        super(spin, coin, bet, stopReel);
        initWins(new StayFrostyLineChecker(this));
    }

    public static void main(String[] args) {
        Spin spin = new StayFrostySpin(173, 0.08, 25, "2,7,12,7|12,5,4,7|12,6,8,1|12,11,7,9|11,12,5,5");
        spin.showMessage();
    }
}
