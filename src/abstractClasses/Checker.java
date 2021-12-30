package abstractClasses;

import java.util.List;

public interface Checker {
    List<Win> initWins(String stopReel);

    static int[][] getMatrix(String stopReel) {
        String[] lines = stopReel.split("\\|");
        int y = lines[0].split(",").length;
        int x = lines.length;
        int[][] result = new int[x][y];
        for (int i = 0; i < result.length; i++) {
            String[] digits = lines[i].split(",");
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = Integer.parseInt(digits[j]);
            }
        }
        return result;
    }
}
