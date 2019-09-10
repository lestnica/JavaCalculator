class ArabicValidator extends BaseValidator {
    private static final Character[] LIST = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    private static final String TYPE = "ARABIC";

    ArabicValidator() {
        super(ArabicValidator.LIST, ArabicValidator.TYPE);
    }
}
