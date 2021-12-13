package Moon_Bitten;

import abstractClasses.Symbol;

import java.util.Set;

public enum MoonBittenSymbol implements Symbol {
    BAT("Bat", 0, new int[]{0, 0, 100, 200, 500, 1000, 2500, 4000, 7500, 15000, 25000, 50000}),
    CASTLE("Castle", 1, new int[]{0, 0, 75, 300, 1000, 2500}),
    CRUCIFIX("Crucifix", 2, new int[]{0, 0, 60, 250, 750, 2000}),
    STATUE("Statue", 3, new int[]{0, 0, 50, 200, 600, 1500}),
    HOLY_WATER("Holy Water", 4, new int[]{0, 0, 40, 125, 375, 750}),
    BLOOD_VIAL("Blood Vial", 5, new int[]{0, 0, 40, 100, 300, 600}),
    A("A", 6, new int[]{0, 0, 15, 35, 75, 150}),
    K("K", 7, new int[]{0, 0, 15, 35, 75, 150}),
    Q("Q", 8, new int[]{0, 0, 10, 25, 50, 100}),
    J("J", 9, new int[]{0, 0, 10, 25, 50, 100}),
    WILD("Wild", 10, new int[]{0, 0, 100, 375, 1000, 3750}),
    TWO_BATS("Two Bats", 17, new int[]{0, 0, 100, 200, 500, 1000, 2500, 4000, 7500, 15000, 25000, 50000});

    private final String name;
    private final int id;
    private final int[] payouts;

    public static final Set<Integer> IDS = Symbol.getIds(values());

    MoonBittenSymbol(String name, int id, int[] payouts) {
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
