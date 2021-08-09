package consts;

public enum Locations {
    UKRAINE("Ukraine"), MULTI_LOCATION("Multi-location");

    private String name;
    Locations(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
