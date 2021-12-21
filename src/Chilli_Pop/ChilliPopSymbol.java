package Chilli_Pop;

import abstractClasses.Symbol;

import java.util.Collection;

public enum ChilliPopSymbol implements Symbol {
    RED_CHILLI("Red Chilli", 0, 12),
    GREEN_CHILLI("Green Chilli", 1, 12),
    GARLIC("Garlic", 2, 7),
    YELLOW_PEPPER("Yellow Pepper", 3, 6),
    RED_PEPPER("Red Pepper", 4, 5),
    GREEN_PEPPER("Green Pepper", 5, 2),
    TOMATO("Tomato", 6, 2),
    ONION("Onion", 7, 2),
    WILD("WILD", 8, 2500);

    private String name;
    private final int id;
    private final int payout;

    public static final Collection<Integer> IDS = Symbol.getIds(values());

    ChilliPopSymbol(String name, int id, int payout) {
        this.name = name;
        this.id = id;
        this.payout = payout;
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
        return new int[] {payout};
    }

    @Override
    public int getPayout(int countOfSymbols) {
        return payout * countOfSymbols;
    }
}