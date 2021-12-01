package stayfrosty;

import abstractClasses.LineCheck;
import abstractClasses.Win;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StayFrostyLineCheck implements LineCheck {
    @Override
    public List<Win> getWins(int[][] matrix) {
        List<Win> result = new ArrayList<>();

        for (int i = 0; i < StayFrostyLine.LINE.length; i++) {
            int[] temp = new int[StayFrostyLine.LINE[0].length];
            for (int j = 0; j < temp.length; j++)
                temp[j] = matrix[j][StayFrostyLine.LINE[i][j]];

            result.add(checkLine(i + 1, temp));
        }
        result.removeAll(Collections.singleton(null));

        return result;
    }

    private StayFrostyWin checkLine(int line, int[] temp) {
        int count = 1;
        for (int i = 1; i < temp.length; i++) {
            if (temp[i] == 0) {
                temp[i] = temp [i-1];
            }
            if (temp[i-1] == temp[i]) count++;
            else {
                if (count < 3 && temp[0] != 1) return null;
                if (count < 2) return null;
                break;
            }
        }

        return new StayFrostyWin(line, temp[0], count);
    }
}
