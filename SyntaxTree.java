class SyntaxTree {
    static final String LEFT = "LEFT";
    static final String RIGHT = "RIGHT";
    static final String OPERATOR = "OPERATOR";

    private Operand left;
    private Operand right;
    private Operand operator;
    private OperandFactory operandFactory;

    SyntaxTree (OperandFactory operandFactory) {
        this.operandFactory = operandFactory;
    }

    int getIntLeft () {
        return this.getNumericInt(this.left);
    }

    int getIntRight () {
        return this.getNumericInt(this.right);
    }

    Operand getLeft() {
        return left;
    }

    Operand getRight() {
        return right;
    }

    String getNumericType () {
        return this.getLeft().getType();
    }

    boolean isSum () {
        return this.getOperatorChar() == '+';
    }

    boolean isDivide () {
        return this.getOperatorChar() == '/';
    }

    boolean isMultiple () {
        return this.getOperatorChar() == '*';
    }

    boolean isMinus () {
        return this.getOperatorChar() == '-';
    }

    boolean isValid () {
        return this.hasAllOperands() && this.isSameNumericOperands();
    }

    void setOperand (String treeType, String value) {
        value = value.trim();

        Operand operand = this.operandFactory.create(value);

        switch (treeType) {
            case SyntaxTree.LEFT:
                this.setLeft(operand);
                break;
            case SyntaxTree.RIGHT:
                this.setRight(operand);
                break;
            default:
                this.setOperator(operand);
        }
    }

    private int getNumericInt (Operand operand) {
        return operand.toInt();
    }

    private Character getOperatorChar () {
        return this.operator.getValue().charAt(0);
    }

    private void setLeft(Operand left) {
        this.left = left;
    }

    private void setRight(Operand right) {
        this.right = right;
    }

    private void setOperator(Operand operator) {
        this.operator = operator;
    }

    private boolean has (Operand operand) {
        return !(operand == null);
    }

    private boolean isValidNumeric (Operand operand) {
        return this.has(operand) && !operand.getType().isBlank();
    }

    private boolean hasLeft () {
        return this.isValidNumeric(this.left);
    }

    private boolean hasRight () {
        return this.isValidNumeric(this.right);
    }

    private boolean hasOperator () {
        return this.has(this.operator);
    }

    private boolean hasAllOperands () {
        return this.hasLeft() && this.hasRight() && this.hasOperator();
    }

    private boolean isSameNumericOperands () {
        return this.left.getType().equals(this.right.getType());
    }
}
