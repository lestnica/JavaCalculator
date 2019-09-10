import java.util.Scanner;

class InputParser {
    static SyntaxTree parseInput(Validator operatorValidator, OperandFactory operandFactory) {
        SyntaxTree syntaxTree = new SyntaxTree(operandFactory);
        Scanner scanner = new Scanner(System.in);

        StringBuilder accumulator = new StringBuilder();

        char[] chars = scanner.nextLine().toCharArray();

        for (char c : chars) {
            String current = Character.toString(c);

            if (operatorValidator.isValid(current)) {
                syntaxTree.setOperand(SyntaxTree.LEFT, accumulator.toString());
                syntaxTree.setOperand(SyntaxTree.OPERATOR, current);

                accumulator = new StringBuilder();

                continue;
            }

            accumulator.append(current);
        }

        syntaxTree.setOperand(SyntaxTree.RIGHT, accumulator.toString());

        scanner.close();

        return syntaxTree;
    }
}
