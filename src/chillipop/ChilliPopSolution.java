package chillipop;

import abstractClasses.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChilliPopSolution extends Solution {

    public ChilliPopSolution(int spin, double coin, int bet, String stopReel) {
        super(spin, coin, bet, stopReel);
        if (checkForWild()) {
            wins = new ArrayList<>();
            wins.add(new ChilliPopWin(1, 8, stopReel.split("[,|]").length));
        }
        else wins = initWins(new ChilliPopClusterCheck());
        totalWin = calcTotalWin();
    }

    public static void main(String[] args) {
        Solution solution = new ChilliPopSolution(16, 30.00, 50,
                "3,9,5,3,5,9|8,8,8,8,8,9|9,7,5,8,8,8|2,6,2,4,8,8|7,5,7,3,1,9|4,6,9,6,4,0");
        solution.showMessage();
    }

    private boolean checkForWild() {
        List<String> list = Arrays.asList(stopReel.split("[,|]"));

        return list.stream()
                .filter(s -> s.equals("8"))
                .count() == list.size();
    }
}