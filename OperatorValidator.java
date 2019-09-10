class OperatorValidator extends BaseValidator {
    private static final Character PLUS = '+';
    private static final Character MINUS = '-';
    private static final Character DIVIDE = '/';
    private static final Character MULTIPLE = '*';

    private static final Character[] LIST = {
            OperatorValidator.PLUS,
            OperatorValidator.MINUS,
            OperatorValidator.DIVIDE,
            OperatorValidator.MULTIPLE
    };

    private static final String TYPE = "OPERATOR";

    OperatorValidator() {
        super(OperatorValidator.LIST, OperatorValidator.TYPE);
    }
}
