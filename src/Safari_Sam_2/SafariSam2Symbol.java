package Safari_Sam_2;

import abstractClasses.Symbol;

import java.util.Set;

public enum SafariSam2Symbol implements Symbol {
    SAM("Sam", 0, new int[]{0, 0, 25, 50, 200}),
    PAM("Pam", 1, new int[]{0, 0, 20, 40, 160}),
    LION("Lion", 2, new int[]{0, 0, 15, 30, 80}),
    ZEBRA("Zebra", 3, new int[]{0, 0, 12, 25, 70}),
    JEEP("Jeep", 4, new int[]{0, 0, 10, 20, 60}),
    TENT("Tent", 5, new int[]{0, 0, 10, 20, 50}),
    A("A", 6, new int[]{0, 0, 7, 12, 30}),
    K("K", 7, new int[]{0, 0, 7, 12, 25}),
    Q("Q", 8, new int[]{0, 0, 5, 10, 25}),
    J("J", 9, new int[]{0, 0, 5, 10, 20}),
    WILD("Wild", 10, new int[]{0, 0, 25, 50, 200}),
    SCATTER("Tree", 11, new int[]{0, 0, 60, 240, 1000});

    private final String name;
    private final int id;
    private final int[] payouts;

    public static final Set<Integer> IDS = Symbol.getIds(values());

    SafariSam2Symbol(String name, int id, int[] payouts) {
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
