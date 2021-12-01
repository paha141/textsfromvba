package primalhunt;

import abstractClasses.Win;
import abstractClasses.LineCheck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrimalHuntLineCheck implements LineCheck {

    @Override
    public List<Win> getWins(int[][] matrix) {
        List<Win> result = new ArrayList<>();

        for (int i = 0; i < PrimalHuntLine.LINE.length; i++) {
            int[] temp = new int[PrimalHuntLine.LINE[0].length];
            for (int j = 0; j < temp.length; j++)
                temp[j] = matrix[j][PrimalHuntLine.LINE[i][j]];

            if (temp[0] == 14) continue;
            result.add(checkLine(i + 1, temp));
        }
        result.removeAll(Collections.singleton(null));

        return result;
    }

    private PrimalHuntWin checkLine(int line, int[] temp) {
        int count = 1;
        int multiplier = 1;
        for (int i = 1; i < temp.length; i++) {
            if (temp[i] >= 11 && temp[i] <= 13) {
                multiplier *= temp[i] - 10;
                temp[i] = temp [i-1];
            }
            if (temp[i-1] == temp[i]) count++;
            else {
                if (count < 3 && temp[0] != 0) return null;
                if (count < 2) return null;
                break;
            }
        }

        if (multiplier == 1) return new PrimalHuntWin(line, temp[0], count);
        else return new PrimalHuntWin(line, temp[0], count, multiplier);
    }
}