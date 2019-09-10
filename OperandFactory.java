class OperandFactory {
    private static final String ARABIC = "ARABIC";
    private static final String ROMAN = "ROMAN";
    private static final String OPERATOR = "OPERATOR";

    private Validator[] validators;

    OperandFactory (Validator[] validators) {
        this.validators = validators;
    }

    private String getTypeByValue (String value) {
        for (Validator validator : this.validators) {
            if (validator.isValid(value)) {
                return validator.getType();
            }
        }

        return "";
    }

    Operand create (String value, String type) {
        switch (type) {
            case OperandFactory.ARABIC:
                return new ArabicOperand(type, value);
            case OperandFactory.ROMAN:
                return new RomanOperand(type, value);
            default:
                return new Operand(type, value);
        }
    }

    Operand create (String value) {
        return this.create(value, this.getTypeByValue(value));
    }
}
