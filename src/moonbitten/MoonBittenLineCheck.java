package moonbitten;

import abstractClasses.LineCheck;
import abstractClasses.Win;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MoonBittenLineCheck implements LineCheck {
    @Override
    public List<Win> getWins(int[][] matrix) {
        List<Win> result = new ArrayList<>();

        for (int i = 0; i < MoonBittenLine.LINE.length; i++) {
            int[] temp = new int[MoonBittenLine.LINE[0].length];
            for (int j = 0; j < temp.length; j++) {
                temp[j] = matrix[j][MoonBittenLine.LINE[i][j]];
            }
            result.add(checkLine(i+1, temp));
            int[] reverse = getReverse(temp);
            if (!Arrays.equals(temp, reverse))
                result.add(checkLine(i+1, reverse));
        }
        result.removeAll(Collections.singleton(null));

        return result;
    }

    private Win checkLine(int line, int[] temp) {
        int count = 0;
        int symbolId = getSymbolId(temp);
        for (int j : temp) {
            if (j == symbolId || j >= 10 && j <= 16 && j != 13 && j != 12)
                count++;
            else if (j == 17 && symbolId == 0) {
                count += 2;
            } else {
                if (count < 3) return null;
                break;
            }
        }
        return biggerWin(line, temp, new MoonBittenWin(line, symbolId, count));
    }

    private static int getSymbolId(int[] temp) {
        int symbolId = 10;
        for (int i : temp) {
            if (i < 10 || i == 17) {
                symbolId = i;
                break;
            }
        }
        return symbolId == 17 ? 0 : symbolId;
    }

    private Win biggerWin(int line, int[] temp, Win win) {
        int count = 0;
        for (int j : temp) {
            if (j >= 10 && j <= 16 && j != 13 && j != 12)
                count++;
            else {
                if (count < 3) return win;
                break;
            }
        }

        Win winWild = new MoonBittenWin(line, 10, count);
        return winWild.getPayout() > win.getPayout() ? winWild : win;
    }
}
