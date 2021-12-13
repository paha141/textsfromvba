package Safari_Sam_2;

import abstractClasses.Spin;

public class SafariSam2Spin extends Spin {
    public SafariSam2Spin(int spin, double coin, int bet, String stopReel) {
        super(spin, coin, bet, stopReel);
        initWins(new SafariSam2LineChecker());
        checkScatterWin();
    }


    public static void main(String[] args) {
        Spin spin = new SafariSam2Spin(173, 5.00, 20, "10,10,10|10,10,10|7,7,2|10,10,10|2,2,8");
        spin.showMessage();
    }

    private void checkScatterWin() {
        int count = 0;
        for (String s : getStopReel().split("[,|]")) {
            if (s.equals(String.valueOf(SafariSam2Symbol.SCATTER.getId())))
                count++;
        }

        if (count >= 3)
            getWins().add(new SafariSam2Win(-1, SafariSam2Symbol.SCATTER.getId(), count));
    }
}
