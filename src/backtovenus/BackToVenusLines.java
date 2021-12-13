package backtovenus;

import abstractClasses.Lines;

class BackToVenusLines implements Lines {
    private BackToVenusLines() {}
    private static BackToVenusLines instance;

    public static BackToVenusLines get() {
        if (instance == null) instance = new BackToVenusLines();
        return instance;
    }

    @Override
    public int[][] getLines() {
        return LINE;
    }

    private static final int[][] LINE = new int[][]{
            {1, 1, 1, 1, 1},
            {0, 0, 0, 0, 0},
            {2, 2, 2, 2, 2},
            {0, 1, 2, 1, 0},
            {2, 1, 0, 1, 2},
            {1, 0, 1, 0, 1},
            {1, 2, 1, 2, 1},
            {0, 1, 0, 1, 0},
            {2, 1, 2, 1, 1},
            {1, 0, 0, 0, 1},
            {1, 2, 2, 2, 1},
            {2, 2, 1, 2, 2},
            {0, 0, 1, 0, 0},
            {2, 1, 1, 1, 2},
            {0, 1, 1, 1, 0},
            {0, 2, 0, 2, 0},
            {2, 0, 2, 0, 2},
            {1, 1, 0, 1, 1},
            {1, 1, 2, 1, 1},
            {2, 2, 0, 2, 2}
    };
}