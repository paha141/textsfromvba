package Primal_Hunt;

import abstractClasses.Symbol;

import java.util.Arrays;
import java.util.Collection;

public enum PrimalHuntSymbol implements Symbol {
    LION("Lion", 0, new int[]{0, 1, 5, 25, 100}),
    SPEARHEAD("Spearhead", 1, new int[]{0, 0, 8, 15, 50}),
    AXE("Axe", 2, new int[]{0, 0, 7, 10, 25}),
    MAMMOTH("Mammoth", 3, new int[]{0, 0, 5, 8, 15}),
    BULL("Bull", 4, new int[]{0, 0, 4, 7, 12}),
    HORSE("Horse", 5, new int[]{0, 0, 4, 7, 12}),
    DEER("Deer", 6, new int[]{0, 0, 3, 5, 8}),
    A("A", 7, new int[]{0, 0, 2, 3, 5}),
    K("K", 8, new int[]{0, 0, 2, 3, 5}),
    Q("Q", 9, new int[]{0, 0, 2, 3, 5}),
    J("J", 10, new int[]{0, 0, 1, 2, 4}),
    SCATTER("Scatter", 14, new int[]{0, 0, 80, 160, 960});

    private String name;
    private final int id;
    private final int[] payouts;

    public static final Collection<Integer> IDS = Symbol.getIds(values());
    public static final Collection<Integer> WILD_IDS = Arrays.asList(11, 12, 13);

    PrimalHuntSymbol(String name, int id, int[] payouts) {
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
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public int[] getPayouts() {
        return payouts;
    }

    @Override
    public boolean isWild() {
        return WILD_IDS.contains(id);
    }
}