package Chilli_Pop;

import abstractClasses.Spin;
import abstractClasses.Win;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ChilliPopSpin extends Spin {
    private static final int BET = 50;

    public ChilliPopSpin(int spin, double coin, int bet, String stopReel) {
        super(spin, coin, bet, stopReel);
        if (checkForWild()) {
            Win win = new ChilliPopWin(1, ChilliPopSymbol.WILD.getId(), stopReel.split("[,|]").length);
            setWins(Collections.singletonList(win));
        } else initWins(new ChilliPopClusterChecker(this));
        setPrefixForWinMessage("");
    }

    public static void main(String[] args) {
        Spin spin = new ChilliPopSpin(32, 0.60, BET,
                "8,8,8,8,8|8,8,8,8,8|8,8,8,8,8|8,8,8,8,8|8,8,8,8,8|8,8,8,8,8");
        spin.showMessage();
    }

    private boolean checkForWild() {
        List<String> list = Arrays.asList(getStopReel().split("[,|]"));
        return list.stream()
                .allMatch(s -> s.equals("8"));
    }
}