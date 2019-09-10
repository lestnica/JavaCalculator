class Operand {
    private String type;
    private String value;

    Operand(String type, String value) {
        this.type = type;
        this.value = value;
    }

    String getType () {
        return this.type;
    }

    String getValue () {
        return this.value;
    }

    int toInt () { return -1; }

    public String toString() { return ""; }
}
