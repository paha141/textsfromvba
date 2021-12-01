package moonbitten;

enum MoonBittenSymbols {
    BAT("Bat"),
    CASTLE("Castle"),
    CRUCIFIX("Crucifix"),
    STATUE("Statue"),
    HOLYWATER("Holy Water"),
    BLOODVIAL("Blood Vial"),
    A("A"),
    K("K"),
    Q("Q"),
    J("J"),
    WILD("Wild");

    private final String name;

    MoonBittenSymbols(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
