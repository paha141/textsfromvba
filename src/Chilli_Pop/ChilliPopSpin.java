package Chilli_Pop;

import abstractClasses.ClusterChecker;
import abstractClasses.LineChecker;
import abstractClasses.Spin;
import abstractClasses.Win;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ChilliPopSpin extends Spin {
    private static final int BET = 50;
    private static final ClusterChecker CLUSTER_CHECKER = new ChilliPopClusterChecker();

    public ChilliPopSpin(int spin, double coin, int bet, String stopReel) {
        super(CLUSTER_CHECKER, spin, coin, bet, stopReel);
        if (checkForWild()) {
            Win win = new ChilliPopWin(1, ChilliPopSymbol.WILD.getId(), stopReel.split("[,|]").length);
            setWins(Collections.singletonList(win));
        } else initClusterWins();
        setPrefixForWinMessage("");
    }

    public static void main(String[] args) {
        Spin spin = new ChilliPopSpin(32, 0.60, BET,
                "8,8,8,8,8|8,8,8,8,8|8,8,8,8,8|8,8,8,8,8|8,8,8,8,8|8,8,8,8,8");
        spin.showMessage();
    }

    private boolean checkForWild() {
        return Arrays.stream(getStopReel().split("[,|]"))
                .allMatch(s -> s.equals("8"));
    }
}