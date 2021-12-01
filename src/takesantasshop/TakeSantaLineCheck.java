package takesantasshop;

import abstractClasses.Win;
import abstractClasses.LineCheck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TakeSantaLineCheck implements LineCheck {

    @Override
    public List<Win> getWins(int[][] matrix) {
        List<Win> result = new ArrayList<>();

        for (int i = 0; i < TakeSantaLine.LINE.length; i++) {
            int[] temp = new int[5];
            for (int j = 0; j < temp.length; j++)
                temp[j] = matrix[j][TakeSantaLine.LINE[i][j]];
            if (temp[0] == 14) continue;
            result.add(checkLine(i + 1, temp));
    }
        result.removeAll(Collections.singleton(null));

    return result;
    }

    private TakeSantaWin checkLine(int line, int[] temp) {
        int count = 1;
        int symbolId = temp[0];
        for (int i = 1; i < temp.length; i++) {
            if (temp[i] == 1) temp[i] = temp[i-1];
            if (temp[i] == temp[i-1] || temp[i-1] == 1) {
                count++;
                if (temp[i] != 1) symbolId = temp[i];
            }
            else {
                if (count < 2) return null;
                if (count < 3 & symbolId != 2 & symbolId != 1) return null;
                break;
            }
        }

        if (symbolId == 0 || symbolId == 14) return null;

        if (symbolId == 1) symbolId = 2;
        return new TakeSantaWin(line, symbolId, count);
    }
}