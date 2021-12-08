package safarisam2;

public enum SafariSam2Symbols {
    SAM("Sam"),
    PAM("Pam"),
    LION("Lion"),
    ZEBRA("Zebra"),
    JEEP("Jeep"),
    TENT("Tent"),
    A("A"),
    K("K"),
    Q("Q"),
    J("J"),
    WILD("Wild"),
    TREE("Tree");

    private final String name;

    SafariSam2Symbols(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
