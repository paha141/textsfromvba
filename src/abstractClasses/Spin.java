package abstractClasses;

import java.util.*;
import java.util.stream.Collectors;

public abstract class Spin {
    private final int spin;
    private final double coin;
    private final int bet;
    private String stopReel;

    private List<Win> wins;
    private int totalWin;

    private Map<String, List<Win>> map;
    private String prefixForWinMessage;

    public Spin(int spin, double coin, int bet, String stopReel) {
        this.spin = spin;
        this.coin = coin;
        this.bet = bet;
        this.stopReel = stopReel;
    }

    protected void initWins(LineChecker lineChecker) {
        prefixForWinMessage = "line ";
        lineChecker.getWins();
        wins.sort(Comparator.comparingInt(Win::getLine));
    }

    protected void initWins(ClusterChecker clusterChecker) {
        prefixForWinMessage = "chain ";
        wins = clusterChecker.getWins();
        wins.sort(Comparator.comparingInt(Win::getLine));
    }


    private void calcTotalWin() {
        if (wins == null || wins.isEmpty()) totalWin = 0;
        else totalWin = wins.stream().mapToInt(Win::getPayout).sum();
    }


    private void initMap() {
        map = wins.stream()
                .collect(Collectors.groupingBy(Win::toString, Collectors.toList()));
    }

    public void showMessage() {
        if (getTotalWin() == 0) return;

        System.out.printf(Locale.ENGLISH, "For spin %d (bet %d, coin %.2f):\n", spin, bet, coin);
        getMessagesList().forEach(System.out::println);
        System.out.println(getTotalForSpinMessage());
        System.out.println(getCurrencyWinMessage());
    }


    private List<String> getMessagesList() {
        if (wins == null || wins.isEmpty()) return Collections.singletonList("");

        return getMap().entrySet().stream()
                .map(entry -> getFullPrefix(entry.getValue()) + ": " + entry.getKey())
                .collect(Collectors.toList());
    }

    private String getFullPrefix(List<Win> wins) {
        StringBuilder prefix = new StringBuilder(prefixForWinMessage);

        if (wins.get(0).getLine() == -1)
            return wins.get(0).toString();

        prefix.append(wins.get(0).getLine());
        for (int i = 1; i < wins.size(); i++) {
            Win prev = wins.get(i - 1);
            Win current = wins.get(i);

            if (current.getLine() != prev.getLine() + 1) prefix.append(", ").append(current.getLine());
            else {
                i = getLastIndexInSequence(wins, i - 1);
                prefix.append("-").append(wins.get(i).getLine());
            }
        }

        return prefix.toString();

    }

    private static int getLastIndexInSequence(List<Win> wins, int index) {
        int lastIndex = index;

        Win first = wins.get(index);
        int count = 1;

        for (int i = index + 1; i < wins.size(); i++) {
            if (wins.get(i).getLine() == first.getLine() + count) {
                count++;
                lastIndex = i;
            }
            else break;
        }

        return lastIndex;
    }


    private String getTotalForSpinMessage() {
        StringJoiner joiner = new StringJoiner("+");
        for (List<Win> list : getMap().values()) {
            int payout = list.get(0).getPayout();

            if (list.size() == 1) joiner.add("" + payout);
            else joiner.add(payout + "*" + list.size());
        }

        return String.format("Total for spin: %s = %d credits;", joiner, getTotalWin());
    }


    private String getCurrencyWinMessage() {
        if (coin == 1) return "Win in currency = win in credits;";
        else
            return String.format(Locale.ENGLISH, "Win in currency: %d * %.2f = %.2f;", getTotalWin(), coin, totalWin * coin);
    }

    protected void removeDuplicateLines() {
        Map<Integer, List<Win>> map = getWins().stream()
                .collect(Collectors.groupingBy(Win::getLine, Collectors.toList()));

        setWins(map.values().stream()
                .map(wins -> wins.stream().max(Win::compareTo).orElseThrow(null))
                .collect(Collectors.toList()));
    }

    public int getSpin() {
        return spin;
    }

    public double getCoin() {
        return coin;
    }

    public int getBet() {
        return bet;
    }

    public String getStopReel() {
        return stopReel;
    }

    public void setStopReel(String stopReel) {
        this.stopReel = stopReel;
    }

    public List<Win> getWins() {
        return wins;
    }

    public void setWins(List<Win> wins) {
        this.wins = wins;
    }

    public int getTotalWin() {
        if (totalWin == 0) calcTotalWin();
        return totalWin;
    }

    private Map<String, List<Win>> getMap() {
        if (map == null) initMap();
        return map;
    }

    public String getPrefixForWinMessage() {
        return prefixForWinMessage;
    }

    public void setPrefixForWinMessage(String prefixForWinMessage) {
        this.prefixForWinMessage = prefixForWinMessage;
    }
}