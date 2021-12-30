package Back_to_Venus;

import abstractClasses.LineChecker;
import abstractClasses.Spin;

import java.util.*;

public class BackToVenusSpin extends Spin {
    private static final int BET = 20;
    private static final LineChecker LINE_CHECKER = new LineChecker(
            BackToVenusSymbol.class,
            BackToVenusLines.get(),
            BackToVenusSymbol.WILD_IDS,
            true, false,
            -1000
    );

    private final String multiplier;

    public BackToVenusSpin(int spin, double coin, int bet, String stopReel) {
        this(spin, coin, bet, stopReel, "");
    }

    public BackToVenusSpin(int spin, double coin, int bet, String stopReel, String multiplier) {
        super(LINE_CHECKER, spin, coin, bet, stopReel);
        this.multiplier = multiplier;

        if (!multiplier.isEmpty()) resetStopReel();
        initLineWins();
    }

    public static void main(String[] args) {
        Spin spin = new BackToVenusSpin(38, 1.20, BET, "1,1,1|1,1,1|1,1,1|1,1,1|1,1,1");
        spin.showMessage();
    }

    private void resetStopReel() {
        Map<Integer, Integer> map = getMultipliers();

        String[] s = getStopReel().split("[,|]");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length; i++) {
            if (s[i].equals("0") || map.containsKey(i)) {
                s[i] = "21";
                if (map.get(i) != null)
                    s[i] = map.get(i) == 2 ? "22" : "23";
            }

            result.append(s[i]);

            if (i % 3 == 2) result.append("|");
            else result.append(",");
        }

        setStopReel(result.toString());
    }

    private Map<Integer, Integer> getMultipliers() {
        Map<Integer, Integer> result = new HashMap<>();
        String[] multipliers = multiplier.split("\\|");
        for (String s : multipliers) {
            String[] mul = s.split(":", 2);
            int index = Integer.parseInt(mul[0]);
            int value = Integer.parseInt(mul[1]);
            result.put(index, value);
        }

        return result;
    }
}