package consts;

public enum ProgrammingLanguages {
    JAVA("Java"), RUBY("Ruby");

    private final String name;
    ProgrammingLanguages(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}