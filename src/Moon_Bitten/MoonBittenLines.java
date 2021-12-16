package Moon_Bitten;

import abstractClasses.Lines;

class MoonBittenLines implements Lines {
    private MoonBittenLines() {}

    private static Lines instance;

    public static Lines get() {
        if (instance == null) instance = new MoonBittenLines();
        return instance;
    }

    @Override
    public int[][] getLines() {
        return LINE;
    }

    private static final int[][] LINE = new int[][]{
            {0, 0, 0, 0, 0, 0},//1
            {1, 1, 1, 1, 1, 1},//2
            {2, 2, 2, 2, 2, 2},//3
            {0, 0, 1, 1, 0, 0},//4
            {0, 0, 2, 2, 0, 0},//5
            {1, 1, 0, 0, 1, 1},//6
            {1, 1, 2, 2, 1, 1},//7
            {2, 2, 0, 0, 2, 2},//8
            {2, 2, 1, 1, 2, 2},//9
            {0, 0, 1, 1, 2, 2},//10
            {2, 2, 1, 1, 0, 0},//11
            {0, 1, 1, 1, 1, 0},//12
            {0, 2, 2, 2, 2, 0},//13
            {1, 2, 2, 2, 2, 1},//14
            {1, 0, 0, 0, 0, 1},//15
            {2, 0, 0, 0, 0, 2},//16
            {2, 1, 1, 1, 1, 2},//17
            {0, 1, 0, 0, 1, 0},//18
            {0, 2, 0, 0, 2, 0},//19
            {1, 0, 1, 1, 0, 1},//20
            {1, 2, 1, 1, 2, 1},//21
            {2, 0, 2, 2, 0, 2},//22
            {2, 1, 2, 2, 1, 2},//23
            {0, 1, 2, 2, 1, 0},//24
            {0, 2, 1, 1, 2, 0},//25
            {1, 0, 2, 2, 0, 1},//26
            {1, 2, 0, 0, 2, 1},//27
            {2, 0, 1, 1, 0, 2},//28
            {2, 1, 0, 0, 1, 2},//29
            {0, 1, 2, 1, 0, 1}//30
    };
}
