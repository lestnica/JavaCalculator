import java.util.Arrays;
import java.util.List;

public class BaseValidator implements Validator {
    private List<Character> list;
    private String type;

    BaseValidator(Character[] array, String type) {
        this.list = Arrays.asList(array);
        this.type = type;
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public boolean isValid(String input) {
        int inputLength = input.length();

        if (inputLength == 0) {
            return false;
        }

        for (int i = 0; i < inputLength; i++) {
            char current = input.charAt(i);

            if (!this.list.contains(current)) {
                return false;
            }
        }

        return true;
    }
}
