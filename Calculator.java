class Calculator {
    private OperandFactory operandFactory;
    private Validator[] validators;

    Calculator () {
        Validator operatorsValidator = new OperatorValidator();
        Validator arabicValidator = new ArabicValidator();
        Validator romanValidator = new RomanValidator();

        Validator[] validators = new Validator[] { operatorsValidator, arabicValidator, romanValidator };

        this.validators = validators;
        this.operandFactory = new OperandFactory(validators);
    }

    private Operand createOperand (int value, String type) {
        return this.operandFactory.create(Integer.toString(value), type);
    }

    private String calculate (SyntaxTree syntaxTree) {
        int left = syntaxTree.getIntLeft();
        int right = syntaxTree.getIntRight();

        int result = -1;

        if (syntaxTree.isMinus()) {
            result = left - right;
        } else if (syntaxTree.isDivide()) {
            result = left / right;
        } else if (syntaxTree.isMultiple()) {
            result = left * right;
        } else if (syntaxTree.isSum()) {
           result = left + right;
        }

        Operand resultOperand = this.createOperand(result, syntaxTree.getNumericType());

        return resultOperand.toString();
    }

    void start () {
        SyntaxTree syntaxTree = InputParser.parseInput(this.validators[0], this.operandFactory);

        if (!syntaxTree.isValid()) {
            throw new IllegalArgumentException();
        }

        System.out.println(this.calculate(syntaxTree));
    }
}
