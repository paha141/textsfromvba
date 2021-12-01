package backtovenus;

import abstractClasses.Win;
import abstractClasses.LineCheck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BackToVenusLineCheck implements LineCheck {

    @Override
    public List<Win> getWins(int[][] matrix) {
        List<Win> result = new ArrayList<>();

        for (int i = 0; i < BackToVenusLine.LINE.length; i++) {
            int[] temp = new int[5];
            for (int j = 0; j < temp.length; j++)
                temp[j] = matrix[j][BackToVenusLine.LINE[i][j]];
            if (temp[0] == 11) continue;
            result.add(checkLine(i + 1, temp));
        }

        result.removeAll(Collections.singleton(null));

        return result;
    }

    private BackToVenusWin checkLine(int line, int[] temp) {
        int count = 1;
        int multiplier = 1;
        for (int i = 1; i < temp.length; i++) {
            if (temp[i] >= 21 && temp[i] <= 23) {
                multiplier *= temp[i] - 20;
                temp[i] = temp [i-1];
            }
            if (temp[i-1] == temp[i]) count++;
            else {
                if (count < 3) return null;
                break;
            }
        }
        if (multiplier == 1) return new BackToVenusWin(line, temp[0], count);
        else return new BackToVenusWin(line, temp[0], count, multiplier);
    }
}