package consts;

public enum Cities {
    LVIV("Lviv");

    private final String name;
    Cities(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
