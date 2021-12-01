package chillipop;

enum ChilliPopSymbols {
    RC("Red Chilli"),
    GC("Green Chilli"),
    G("Garlic"),
    YP("Yellow Pepper"),
    RP("Red Pepper"),
    GP("Green Pepper"),
    T("Tomato"),
    O("Onion"),
    W("WILD");
    private String name;

    ChilliPopSymbols(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}