package backtovenus;

import abstractClasses.Symbols;

enum BackToVenusSymbols implements Symbols {
    FARMER("Farmer"),
    PLANT_ALIEN("Plant Alien"),
    COW("Cow"),
    BARN("Barn"),
    PLANTS("Plants"),
    CROP_CIRCLE("Crop Circle"),
    A("A"),
    K("K"),
    Q("Q"),
    J("J");

    private String name;

    BackToVenusSymbols(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}