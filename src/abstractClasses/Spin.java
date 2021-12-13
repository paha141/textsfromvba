package abstractClasses;

import java.util.*;

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

    private int[][] getMatrix() {
        String[] lines = stopReel.split("\\|");
        int y = lines[0].split(",").length;
        int x = lines.length;
        int[][] result = new int[x][y];
        for (int i = 0; i < result.length; i++) {
            String[] digits = lines[i].split(",");
            for (int j = 0; j < result[i].length; j++)
                result[i][j] = Integer.parseInt(digits[j]);
        }

        return result;
    }

    protected void initWins(LineChecker lineChecker) {
        prefixForWinMessage = "line ";
        wins = lineChecker.getWins(getMatrix());
    }

    protected void initWins(ClusterChecker clusterChecker) {
        prefixForWinMessage = "chain ";
        wins = clusterChecker.getWins(getMatrix());
    }


    protected void calcTotalWin() {
        if (wins.isEmpty()) totalWin = 0;
        totalWin = wins.stream().mapToInt(Win::getPayout).sum();
    }


    private void initMap() {

        map = new HashMap<>();

        for (Win win : wins) {
            String message = win.toString();
            if (!map.containsKey(message))
                map.put(message, new ArrayList<>());
            map.get(message).add(win);
        }
    }

    public void showMessage() {
        System.out.printf(Locale.ENGLISH, "For spin %d (bet %d, coin %.2f):\n", spin, bet, coin);
        getMessagesList().forEach(System.out::println);
        System.out.println(getTotalForSpinMessage());
        System.out.println(getCurrencyWinMessage());
    }


    private List<String> getMessagesList() {
        if (wins == null || wins.isEmpty()) return Collections.singletonList("");

        List<String> result = new ArrayList<>();

        for (Map.Entry<String, List<Win>> entry : getMap().entrySet()) {
            StringBuilder prefix = new StringBuilder(prefixForWinMessage);
            List<Win> wins = entry.getValue();
            wins.sort(Comparator.comparingInt(Win::getLine));

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

            result.add(prefix + ": " + entry.getKey());
        }

        return result;
    }

    private int getLastIndexInSequence(List<Win> wins, int index) {
        int result = index;

        Win first = wins.get(index);
        int count = 1;

        for (int i = index + 1; i < wins.size(); i++) {
            if (wins.get(i).getLine() == first.getLine() + count) {
                count++;
                result = i;
            } else break;
        }

        return result;
    }


    private String getTotalForSpinMessage() {
        StringJoiner joiner = new StringJoiner("+");
        for (List<Win> list : getMap().values()) {
            if (list.size() == 1) joiner.add("" + list.get(0).getPayout());
            else joiner.add(list.get(0).getPayout() + "*" + list.size());
        }

        return String.format("Total for spin: %s = %d credits;", joiner, getTotalWin());
    }


    private String getCurrencyWinMessage() {
        if (coin == 1) return "Win in currency = win in credits;";
        else
            return String.format(Locale.ENGLISH, "Win in currency: %d * %.2f = %.2f;", getTotalWin(), coin, totalWin * coin);
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

    protected Map<String, List<Win>> getMap() {
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