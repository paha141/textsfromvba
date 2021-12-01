package primalhunt;

import abstractClasses.Symbols;

enum PrimalHuntSymbols implements Symbols {
    LION("Lion"),
    SPEARHEAD("Spearhead"),
    AXE("Axe"),
    MAMMOTH("Mammoth"),
    BULL("Bull"),
    HORSE("Horse"),
    DEER("Deer"),
    A("A"),
    K("K"),
    Q("Q"),
    J("J");
    private final String name;

    PrimalHuntSymbols(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}