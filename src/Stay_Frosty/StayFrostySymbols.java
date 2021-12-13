package Stay_Frosty;

import abstractClasses.Symbols;

import java.util.Set;

public enum StayFrostySymbols implements Symbols {
    GREEN_GNOME("Green Gnome", 1, new int[]{0, 1, 5, 25, 100}),
    RED_GNOME("Red Gnome", 2, new int[]{0, 0, 8, 15, 50}),
    SOCK("Sock", 3, new int[]{0, 0, 7, 10, 25}),
    SNOWBALL("Snowball", 4, new int[]{0, 0, 5, 8, 15}),
    BELLS("Bells", 5, new int[]{0, 0, 4, 7, 12}),
    GIFT("Gift", 6, new int[]{0, 0, 4, 7, 12}),
    A("A", 7, new int[]{0, 0, 3, 5, 8}),
    K("K", 8, new int[]{0, 0, 2, 3, 5}),
    Q("Q", 9, new int[]{0, 0, 2, 3, 5}),
    J("J", 10, new int[]{0, 0, 2, 3, 5}),
    Ten("10", 11, new int[]{0, 0, 1, 2, 4}),
    SCATTER("Scatter", 12, new int[]{0, 0, 125, 250, 1250});

    private final String name;
    private final int id;
    private final int[] payouts;

    public static final Set<Integer> IDS = Symbols.getIds(values());

    StayFrostySymbols(String name, int id, int[] payouts) {
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
