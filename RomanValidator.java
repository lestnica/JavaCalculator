class RomanValidator extends BaseValidator {
    private static final Character[] LIST = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};
    private static final String TYPE = "ROMAN";

    RomanValidator() {
        super(RomanValidator.LIST, RomanValidator.TYPE);
    }
}
