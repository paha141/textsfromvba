package takesantasshop;

import abstractClasses.Symbols;

enum TakeSantaSymbols implements Symbols {
    BALL("Ball"),
    GINGERBREAD("Gingerbread"),
    SOCK("Sock"),
    BELLS("Bells"),
    HORSE("Horse"),
    CANE("Cane"),
    A("A"),
    K("K"),
    Q("Q"),
    J("J"),
    TEN("10"),
    NINE("9");

    private final String name;

    TakeSantaSymbols(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}