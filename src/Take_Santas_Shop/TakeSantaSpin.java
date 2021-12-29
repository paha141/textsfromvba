package Take_Santas_Shop;

import abstractClasses.Spin;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TakeSantaSpin extends Spin {
    private static final int BET = 20;

    private final String currentWildPositions;

    public TakeSantaSpin(int spin, double coin, int bet, String stopReel) {
        this(spin, coin, bet, stopReel, "", false);
    }

    public TakeSantaSpin(int spin, double coin, int bet, String stopReel, String currentWildPositions, boolean isBombCounterZero) {
        super(spin, coin, bet, stopReel);
        this.currentWildPositions = currentWildPositions;
        if (isBombCounterZero)
            resetStopReel();

        initWins(new TakeSantaLineChecker(this));
    }

    public static void main(String[] args) {
        Spin spin = new TakeSantaSpin(548, 2.50, BET, "11,10,7,9|13,4,0,5|8,13,9,14|13,14,10,12|11,7,10,3",
                "12,13,14,15,16,17,18,19,4,5,0,1,8,9,10", true);
        spin.showMessage();
    }

    private void resetStopReel() {
        List<Integer> bombs = getBombs();

        String[] s = getStopReel().split("[,|]");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length; i++) {
            if (s[i].equals("0") || bombs.contains(i))
                s[i] = "1";

            result.append(s[i]);
            if (i % 4 == 3) result.append('|');
            else result.append(',');
        }

        setStopReel(result.toString());
    }

    private List<Integer> getBombs() {
        return Arrays.stream(currentWildPositions.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public String getCurrentWildPositions() {
        return currentWildPositions;
    }
}