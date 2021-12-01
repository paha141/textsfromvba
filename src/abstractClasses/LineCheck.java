package abstractClasses;

import java.util.List;

public interface LineCheck {

    List<Win> getWins(int[][] matrix);

    default int[] getReverse(int[] arr) {
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[arr.length-i-1];
        }

        return result;
    }
}