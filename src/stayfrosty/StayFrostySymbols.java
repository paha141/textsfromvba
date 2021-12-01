package stayfrosty;

public enum StayFrostySymbols {
    GREENGNOME("Green Gnome"),
    REDGNOME("Red Gnome"),
    SOCK("Sock"),
    SNOWBALL("Snowball"),
    BELLS("Bells"),
    GIFT("Gift"),
    A("A"),
    K("K"),
    Q("Q"),
    J("J"),
    Ten("10"),
    SCATTER("Scatter");

    private final String name;

    StayFrostySymbols(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
