package moonbitten;

import abstractClasses.Solution;
import abstractClasses.Win;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MoonBittenSolution extends Solution {
    public MoonBittenSolution(int spin, double coin, int bet, String stopReel) {
        super(spin, coin, bet, stopReel);
        wins = initWins(new MoonBittenLineCheck());
        removeDuplicateLines();
        totalWin = calcTotalWin();
    }

    public static void main(String[] args) {
        Solution solution = new MoonBittenSolution(92, 0.04, 150, "4,9,10|5,5,15|8,5,15|10,5,16|5,5,16|9,10,4");
        solution.showMessage();
    }

    private void removeDuplicateLines() {
        Map<Integer, Win> map = new HashMap<>();
        for (Win win : getWins()) {
            if (map.containsKey(win.getLine())) {
                Win value =  map.get(win.getLine());
                Win bigger = value.getPayout() > win.getPayout() ?  value : win;
                map.put(bigger.getLine(), bigger);
            } else map.put(win.getLine(), win);
        }
        wins = new ArrayList<>(map.values());
    }
}
