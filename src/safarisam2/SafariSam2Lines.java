package safarisam2;

import abstractClasses.Lines;

class SafariSam2Lines implements Lines {
    private SafariSam2Lines() {
    }

    private static SafariSam2Lines instance;

    public static SafariSam2Lines get() {
        if (instance == null) instance = new SafariSam2Lines();
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
            {0, 1, 1, 1, 0},//6
            {2, 1, 1, 1, 2},//7
            {1, 0, 0, 0, 1},//8
            {1, 2, 2, 2, 1},//9
            {1, 1, 0, 1, 1},//10
            {1, 1, 2, 1, 1},//11
            {0, 0, 1, 0, 0},//12
            {2, 2, 1, 2, 2},//13
            {0, 1, 0, 1, 0},//14
            {2, 1, 2, 1, 2},//15
            {1, 0, 1, 0, 1},//16
            {1, 2, 1, 2, 1},//17
            {0, 2, 2, 2, 0},//18
            {2, 0, 0, 0, 2},//19
            {2, 2, 0, 2, 2},//20
            {0, 0, 2, 0, 0},//21
            {0, 2, 0, 2, 0},//22
            {2, 0, 2, 0, 2},//23
            {0, 0, 1, 2, 2},//24
            {2, 2, 1, 0, 0},//25
            {1, 0, 2, 0, 1},//26
            {1, 2, 0, 2, 1},//27
            {1, 2, 1, 0, 0},//28
            {1, 0, 1, 2, 2},//29
            {0, 1, 2, 2, 2},//30
            {2, 1, 0, 0, 0},//31
            {0, 0, 0, 1, 2},//32
            {2, 2, 2, 1, 0},//33
            {1, 0, 1, 2, 1},//34
            {1, 2, 1, 0, 1},//35
            {0, 1, 1, 1, 1},//36
            {2, 1, 1, 1, 1},//37
            {0, 0, 1, 1, 1},//38
            {2, 2, 1, 1, 1},//39
            {2, 1, 2, 1, 0},//40
            {0, 1, 0, 1, 2},//41
            {1, 0, 0, 0, 0},//42
            {1, 2, 2, 2, 2},//43
            {0, 0, 0, 1, 0},//44
            {2, 2, 2, 1, 2},//45
            {0, 1, 0, 0, 0},//46
            {2, 1, 2, 2, 2},//47
            {1, 0, 1, 1, 1},//48
            {1, 2, 1, 1, 1},//49
            {1, 1, 1, 0, 1},//50
    };

}
