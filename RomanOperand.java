import java.util.List;

class RomanOperand extends NumericOperand {
    RomanOperand(String type, String value) {
        super(type, value);
    }

    int toInt() {
        int result = 0;

        char[] arr = this.getValue().toCharArray();

        for (char c : arr) {
            String s = Character.toString(c);

            result += RomanNumeral.valueOf(s).getValue();
        }

        return result;
    }

    public String toString () {
        int arabicValueToConvert = Integer.parseInt(this.getValue());
        StringBuilder stringBuilder = new StringBuilder();
        List<RomanNumeral> romanNumerals = RomanNumeral.getReverseSortedValues();

        int acc = 0;

        int listSize = romanNumerals.size();

        while (arabicValueToConvert > 0 && acc < listSize) {
            RomanNumeral current = romanNumerals.get(acc);

            int currentArabicValue = current.getValue();
            String currentRomanValue = current.name();

            if (currentArabicValue <= arabicValueToConvert) {
                stringBuilder.append(currentRomanValue);

                arabicValueToConvert = arabicValueToConvert - currentArabicValue;
            } else {
                acc++;
            }
        }

        return stringBuilder.toString();
    }
}
