package Take_Santas_Shop;

import abstractClasses.Symbols;

import java.util.Set;

public enum TakeSantaSymbols implements Symbols {
    WILD("BALL", 1, new int[]{0, 1, 4, 12, 60}),
    BALL("Ball", 2, new int[]{0, 1, 4, 12, 60}),
    GINGERBREAD("Gingerbread", 3, new int[]{0, 0, 3, 6, 20}),
    SOCK("Sock", 4, new int[]{0, 0, 3, 5, 18}),
    BELLS("Bells", 5, new int[]{0, 0, 2, 4, 12}),
    HORSE("Horse", 6, new int[]{0, 0, 2, 4, 12}),
    CANE("Cane", 7, new int[]{0, 0, 2, 4, 12}),
    A("A", 8, new int[]{0, 0, 2, 4, 12}),
    K("K", 9, new int[]{0, 0, 1, 2, 6}),
    Q("Q", 10, new int[]{0, 0, 1, 2, 6}),
    J("J", 11, new int[]{0, 0, 1, 2, 6}),
    TEN("10", 12, new int[]{0, 0, 1, 2, 6}),
    NINE("9", 13, new int[]{0, 0, 1, 2, 6});

    private final String name;
    private final int id;
    private final int[] payouts;

    public static final Set<Integer> IDS = Symbols.getIds(values());

    TakeSantaSymbols(String name, int id, int[] payouts) {
        this.name = name;
        this.id = id;
        this.payouts = payouts;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public int[] getPayouts() {
        return payouts;
    }

}