package safarisam2;

import abstractClasses.LineCheck;
import abstractClasses.Win;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SafariSam2LineCheck implements LineCheck {


    @Override
    public List<Win> getWins(int[][] matrix) {
        List<Win> result = new ArrayList<>();

        for (int i = 0; i < SafariSam2Line.LINE.length; i++) {
            int[] temp = new int[SafariSam2Line.LINE[0].length];
            for (int j = 0; j < temp.length; j++)
                temp[j] = matrix[j][SafariSam2Line.LINE[i][j]];

            if (temp[0] == 11) continue;
            result.add(checkLine(i + 1, temp));
        }
        result.removeAll(Collections.singleton(null));

        return result;
    }

    private Win checkLine(int line, int[] temp) {
        int count = 0;
        int symbolId = getSymbolId(temp);
        for (int i : temp) {
            if (i == symbolId || i == 10) count++;
            else {
                if (count < 3) return null;
                break;
            }
        }
        return new SafariSam2Win(line, symbolId, count);
    }

    private static int getSymbolId(int[] temp) {
        int symbolId = 10;
        for (int i : temp) {
            if (i < 10) {
                symbolId = i;
                break;
            }
        }
        return symbolId;
    }

}
