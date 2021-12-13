package Chilli_Pop;

import abstractClasses.Spin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChilliPopSpin extends Spin {

    public ChilliPopSpin(int spin, double coin, int bet, String stopReel) {
        super(spin, coin, bet, stopReel);
        if (checkForWild()) {
            wins = new ArrayList<>();
            wins.add(new ChilliPopWin(1, ChilliPopSymbol.WILD.getId(), stopReel.split("[,|]").length));

        } else wins = initWins(new ChilliPopClusterChecker());
    }

    public static void main(String[] args) {
        Spin spin = new ChilliPopSpin(32, 0.60, 50,
                "8,8,8,8,5|8,8,8,8,8|3,7,9,3,5|8,8,8,8,8|8,5,7,1,5|8,8,8,8,6");
        spin.showMessage();
    }

    private boolean checkForWild() {
        List<String> list = Arrays.asList(stopReel.split("[,|]"));

        return list.stream()
                .filter(s -> s.equals("8"))
                .count() == list.size();
    }
}