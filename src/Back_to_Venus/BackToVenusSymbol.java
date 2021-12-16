package Back_to_Venus;

import abstractClasses.Symbol;

import java.util.List;

public enum BackToVenusSymbol implements Symbol {
    FARMER("Farmer", 1, new int[]{0, 0, 30, 100, 300}),
    PLANT_ALIEN("Plant Alien", 2, new int[]{0, 0, 20, 60, 120}),
    COW("Cow", 3, new int[]{0, 0, 15, 40, 80}),
    BARN("Barn", 4, new int[]{0, 0, 10, 30, 60}),
    PLANTS("Plants", 5, new int[]{0, 0, 10, 30, 60}),
    CROP_CIRCLE("Crop Circle", 6, new int[]{0, 0, 10, 30, 60}),
    A("A", 7, new int[]{0, 0, 5, 15, 30}),
    K("K", 8, new int[]{0, 0, 5, 15, 30}),
    Q("Q", 9, new int[]{0, 0, 5, 10, 20}),
    J("J", 10, new int[]{0, 0, 5, 10, 20});

    private String name;
    private final int id;
    private final int[] payouts;

    public static final List<Integer> IDS = Symbol.getIds(values());

    BackToVenusSymbol(String name, int id, int[] payouts) {
        this.name = name;
        this.id = id;
        this.payouts = payouts;
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
    public String toString() {
        return name;
    }

    @Override
    public int[] getPayouts() {
        return payouts;
    }
}