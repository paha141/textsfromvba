package chillipop;

import abstractClasses.Spin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChilliPopSpin extends Spin {

    public ChilliPopSpin(int spin, double coin, int bet, String stopReel) {
        super(spin, coin, bet, stopReel);
        if (checkForWild()) {
            wins = new ArrayList<>();
            wins.add(new ChilliPopWin(1, ChilliPopSymbols.WILD.getId(), stopReel.split("[,|]").length));

        } else wins = initWins(new ChilliPopClusterCheck());
    }

    public static void main(String[] args) {
        Spin spin = new ChilliPopSpin(16, 30.00, 50,
                "8,8,8,8,8,8|8,8,8,8,8,8|8,8,8,8,8,8|8,8,8,8,8,8|8,8,8,8,8,8|8,8,8,8,8,8");
        spin.showMessage();
    }

    private boolean checkForWild() {
        List<String> list = Arrays.asList(stopReel.split("[,|]"));

        return list.stream()
                .filter(s -> s.equals("8"))
                .count() == list.size();
    }
}