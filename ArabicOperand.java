class ArabicOperand extends NumericOperand {
    ArabicOperand(String type, String value) {
        super(type, value);
    }

    int toInt () {
        return Integer.parseInt(this.getValue());
    }

    public String toString () {
        return this.getValue();
    }
}
