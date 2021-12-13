package Back_to_Venus;

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
            {1, 1, 1, 1, 1},//1
            {0, 0, 0, 0, 0},//2
            {2, 2, 2, 2, 2},//3
            {0, 1, 2, 1, 0},//4
            {2, 1, 0, 1, 2},//5
            {1, 0, 1, 0, 1},//6
            {1, 2, 1, 2, 1},//7
            {0, 1, 0, 1, 0},//8
            {2, 1, 2, 1, 1},//9
            {1, 0, 0, 0, 1},//10
            {1, 2, 2, 2, 1},//11
            {2, 2, 1, 2, 2},//12
            {0, 0, 1, 0, 0},//13
            {2, 1, 1, 1, 2},//14
            {0, 1, 1, 1, 0},//15
            {0, 2, 0, 2, 0},//16
            {2, 0, 2, 0, 2},//17
            {1, 1, 0, 1, 1},//18
            {1, 1, 2, 1, 1},//19
            {2, 2, 0, 2, 2} //20
    };
}