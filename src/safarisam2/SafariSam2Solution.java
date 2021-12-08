package safarisam2;

import abstractClasses.Solution;

public class SafariSam2Solution extends Solution {
    public SafariSam2Solution(int spin, double coin, int bet, String stopReel) {
        super(spin, coin, bet, stopReel);
        wins = initWins(new SafariSam2LineCheck());
        checkScatterWin();
        totalWin = calcTotalWin();
    }


    public static void main(String[] args) {
        Solution solution = new SafariSam2Solution(173, 5.00, 20, "10,10,10|10,10,10|7,7,2|10,10,10|2,2,8");
        solution.showMessage();
    }

    private void checkScatterWin() {
        int count = 0;
        for (String s: stopReel.split("[,|]")) {
            if (s.equals("11"))
                count++;
        }

        if (count >= 3)
            wins.add(new SafariSam2Win(-1, 11, count));
    }
}
