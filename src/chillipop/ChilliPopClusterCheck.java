package chillipop;

import abstractClasses.ClusterCheck;
import abstractClasses.Win;

import java.util.ArrayList;
import java.util.List;

public class ChilliPopClusterCheck implements ClusterCheck {
    @Override
    public List<Win> getWins(int[][] matrix) {
        List<Win> result = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++) {
                int symbolId = matrix[i][j];
                int[] countOfWild = new int[]{0};
                int[] countOfSymbols = new int[]{0};
                if (symbolId >= 0 && symbolId <= 7) {
                    matrix[i][j] = -1;
                    recursion(matrix, symbolId, countOfSymbols, countOfWild, i, j);
                    resetMatrix(matrix);

                    if (countOfSymbols[0] > 2)
                        result.add(new ChilliPopWin(result.size() + 1, symbolId, countOfSymbols[0], countOfWild[0] + 1));
                }
            }

        return result;
    }

    private void recursion(int[][] matrix, int symbolId, int[] countOfSymbols, int[] countOfWild, int x, int y) {
        countOfSymbols[0]++;
        for (int i = x - 1; i <= x + 1; i++) {
            if (i < 0 || i >= matrix.length) continue;

            for (int j = y - 1; j <= y + 1; j++) {
                if (j < 0 || j >= matrix[i].length) continue;
                if (i == x && j == y) continue;
                if ((i == x - 1 || i == x + 1) && (j == y - 1 || j == y + 1)) continue;

                if (matrix[i][j] == symbolId || matrix[i][j] == ChilliPopSymbols.WILD.getId()) {
                    if (matrix[i][j] != ChilliPopSymbols.WILD.getId()) matrix[i][j] = -1;
                    else {
                        countOfWild[0]++;
                        matrix[i][j] = -2;
                    }
                    recursion(matrix, symbolId, countOfSymbols, countOfWild, i, j);
                }
            }
        }
    }

    private void resetMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                if (matrix[i][j] == -2) matrix[i][j] = ChilliPopSymbols.WILD.getId();
    }
}